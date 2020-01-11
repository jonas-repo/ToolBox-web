package com.toolbox.springboot.backend.apirest.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.ProductImage;
import com.toolbox.springboot.backend.apirest.services.ProductImageService;
import com.toolbox.springboot.backend.apirest.services.ProductService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/renter")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageService productImageService;
	/**
	 * This method is used to return a list of all products
	 */
	@GetMapping("/products")
	public List<Product> index(){
		return productService.findAll();
	}
	
	/**
	 * This method is used to sort the result of all the products
	 * @param page
	 * @return a sorted list of all the products
	 */
	@GetMapping("/products/page/{page}")
	public Page<Product> index(@PathVariable int page){
		return productService.findAll(PageRequest.of(page, 5));
	}
	
	/**
	 * this is used to find an specific product finding it by the id
	 * @param id
	 * @return Product
	 */
	@GetMapping("/products/{id}")
	public ResponseEntity<?> showProduct(@PathVariable Long id) {
		
		Product product = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			product = productService.findById(id);
		}catch(DataAccessException e) {
			response.put("message", "Error while making the query!");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(product == null) {
			response.put("message", "The product ID: ".concat(id.toString().concat(" doesn't exist in the database!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	/*
	 * This method is used to create a Product
	 */
	@PostMapping("/products")
	public ResponseEntity<?> createProduct(@RequestParam("product") String modelProduct, @RequestParam("images") MultipartFile[] images) {
		
		ObjectMapper mapper = new ObjectMapper();
		Product product = null;
		try {
			product = mapper.readValue(modelProduct, Product.class);
		} catch ( JsonProcessingException e) {
			e.printStackTrace();
		}
		
		Product nProduct = null;
		Map<String, Object> response = new HashMap<>();
				
		try {
			nProduct = productService.save(product);
			uploadImagesProduct(images,nProduct);
		}catch(DataAccessException e) {
			response.put("message", "Error while making the query!");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The product was successfully created!");
		response.put("product", nProduct);
		return new ResponseEntity<Map<String, Object>>( response, HttpStatus.CREATED);
	}
	
	/*
	 * This method is used to update a Product
	 */
	@PutMapping("/products")
	public ResponseEntity<?> updateProduct(@RequestParam("product") String modelProduct, @RequestParam("images") MultipartFile[] images) {
		
		ObjectMapper mapper = new ObjectMapper();
		Product product = null;
		
		try {
			product = mapper.readValue(modelProduct, Product.class);
		} catch ( JsonProcessingException e) {
			e.printStackTrace();
		}
		
		Product currentProduct = productService.findById(product.getProductId());
		Product updatedProduct = null;
		Map<String, Object> response = new HashMap<>();
		
		if(currentProduct == null) {
			response.put("message","Error: It couldn't be updated, the product doesn't exist in the database!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {	
			currentProduct.setProductName(product.getProductName());
			currentProduct.setProductBrand(product.getProductBrand());
			currentProduct.setProductModel(product.getProductModel());
			currentProduct.setProductDescription(product.getProductDescription());
			currentProduct.setProductPrice(product.getProductPrice());
			currentProduct.setProductQuantity(product.getProductQuantity());
			
			updatedProduct = productService.save(currentProduct);
			
			uploadImagesProduct(images,updatedProduct);
			
		}catch(DataAccessException e) {	
			response.put("message", "Error when updating the product in the database");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		response.put("message", "The product has been successfully updated!");
		response.put("product", updatedProduct);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/*
	 * This method is used to delete a Product
	 */
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {	
			List<ProductImage> productImages = null;
			Product product = productService.findById(id);
			productImages = product.getProductImage();
			//findAllProductImages(id);
			if(productImages.size()>0) {
				for(ProductImage productImage: productImages) {
					String nameOldImage = productImage.getImageRoute();
					
					if(nameOldImage != null && nameOldImage.length()>0) {
						Path routeOldImage = Paths.get("uploads/productImages").resolve(nameOldImage).toAbsolutePath();
						File fileOldImage = routeOldImage.toFile();
						if(fileOldImage.exists() && fileOldImage.canRead()) {
							fileOldImage.delete();
						}
					}
					
				}
			}
			
			productService.delete(id);

			
		}catch(DataAccessException e) {
			response.put("message", "Error when deleting the product from the database");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The product was successfully removed!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/*
	 * This method is used to upload a group of elements
	 */
	//@PostMapping("/products/upload")
	//public ResponseEntity<?> uploadImagesProduct(@RequestParam("images") MultipartFile[] images, @RequestParam("productId") Long id){
	public ResponseEntity<?> uploadImagesProduct(MultipartFile[] images, Product product){
		
		Map<String, Object> response = new HashMap<>();
		List<ProductImage> productImages = new ArrayList<>();
				
		for(MultipartFile image: images) {
			if(productImageService.findByProductImageName(image.getOriginalFilename())==null) {
				ProductImage productImage = new ProductImage();
				String imageName = UUID.randomUUID().toString() + "_" +image.getOriginalFilename().replace(" ", "");
				Path imageRoute = Paths.get("uploads/productImages").resolve(imageName).toAbsolutePath();
				try {
					Files.copy(image.getInputStream(), imageRoute);
				} catch (IOException e) {
					response.put("message", "Error when uploading the image.");
					response.put("error", e.getMessage().concat(":").concat(e.getCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
				productImage.setImageRoute(imageName);
				productImage.setProductId(product);
				
				productImages.add(productImage);
			}
		}
		
		try {
			productImageService.saveAll(productImages);
		}catch(DataAccessException e) {
			response.put("message", "Error while making the query!");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("product", product);
		response.put("message", "You have uploaded all the images correctly");
	
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	/**
	 * This method is used to show an specific image when is called
	 * @param imageName
	 * @return an image
	 */
	@GetMapping("/uploads/img/{imageName:.+}")
	public ResponseEntity<Resource> showImage(@PathVariable String imageName){
		
		Path routeFile = Paths.get("uploads/productImages").resolve(imageName).toAbsolutePath();
		Resource resource = null;
		
		try {		
			resource =  new UrlResource(routeFile.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if(!resource.exists() && !resource.isReadable()) {
			throw new RuntimeException("Error when uploading the image");
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+"\"");
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	/**
	 * This method is used to delete an unique image
	 * @param id
	 * @return status ok if the query is successfully executed.
	 */
	@DeleteMapping("/uploads/img/{id}")
	public ResponseEntity<?> deleteImage(@PathVariable Long id){
		Map<String, Object> response = new HashMap<>();
		
		try {
			ProductImage productImage = productImageService.findById(id);
			if(productImage!=null) {
				String nameOldImage = productImage.getImageRoute();
				System.out.println(nameOldImage);
				if(nameOldImage != null && nameOldImage.length()>0) {
					Path routeOldImage = Paths.get("uploads/productImages").resolve(nameOldImage).toAbsolutePath();
					File fileOldImage = routeOldImage.toFile();
					if(fileOldImage.exists() && fileOldImage.canRead()) {
						fileOldImage.delete();
						System.out.println("The file was deleted");
					}
				}
				
				productImageService.delete(id);
				System.out.println("The file was deleted from the db");
			}

		}catch(DataAccessException e) {
			response.put("message", "Error when deleting the product from the database");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The product was successfully removed!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/products/filter-products/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> filterProducts(@PathVariable String term){
		return productService.findByProductName(term);
	}
	
}
