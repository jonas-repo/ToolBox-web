package com.toolbox.springboot.backend.apirest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toolbox.springboot.backend.apirest.model.entity.Product;
import com.toolbox.springboot.backend.apirest.model.entity.ProductCategory;
import com.toolbox.springboot.backend.apirest.model.entity.ProductComments;
import com.toolbox.springboot.backend.apirest.model.entity.ProductResponse;
import com.toolbox.springboot.backend.apirest.services.ProductCategoryService;
import com.toolbox.springboot.backend.apirest.services.ProductCommentsService;
import com.toolbox.springboot.backend.apirest.services.ProductService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController //se le indica que va a ser un controlador rest
@RequestMapping("/api") //se crea el endpoint para poder consumir los servicios
public class ProductRestControllerIvan {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductCommentsService productCommentsService;
	
	private String respuesta="productos";
	 
	//Implementacion del metodo para leer todo
		@GetMapping("/productos")
		public ResponseEntity<?> index(){
			
			List<Product> productos = productService.findAll();
			Map<Object,Object> response = new HashMap<>();
			List<ProductResponse> respuestaProductosList=new ArrayList<>();
			
			for(Product product:productos)
			{
				ProductResponse respuestaProductos= new ProductResponse();
				
				respuestaProductos.setProductComments(product.getProductComments());
				respuestaProductos.setProductImage(product.getProductImage());
				respuestaProductos.setProductRate(product.getProductRate());
				respuestaProductos.setProducts(product);
				
				respuestaProductosList.add(respuestaProductos);

				//response.put(product.getProductId(), respuestaProductos);
				//Object[] obj = {product,product.getCalificacionProduct(),product.getComentariosProducto(),product.getImagenesProducto()};
				
				
			}
			response.put(respuesta, respuestaProductosList);
			
			return new ResponseEntity<Map<Object,Object>>(response,HttpStatus.OK);
		}
		
		
		//Implementacion del metodo para leer un producto por ID
		@GetMapping("/productos/{id}")
		public ResponseEntity<?> index2(@PathVariable Long id){
			
			Product product = productService.findById(id);
			ProductResponse respuestaProductos= new ProductResponse();
			Map<Object,Object> response = new HashMap<>();

				
			respuestaProductos.setProductComments(product.getProductComments());
			respuestaProductos.setProductImage(product.getProductImage());
			respuestaProductos.setProductRate(product.getProductRate());
			respuestaProductos.setProducts(product);
			
			response.put(respuesta, respuestaProductos);
			
			return new ResponseEntity<Map<Object,Object>>(response,HttpStatus.OK);
		}
		
		
		@GetMapping("/products/categories/{category}")
		public List<ProductCategory> showProductsByCategories(@PathVariable String category){
			return productCategoryService.getProductsByCategory(category);
			
		}
		
		@GetMapping("/products/categories")
		public List<String> showCategories(){
			return productCategoryService.findAllCategories();
		}
		
		@PostMapping("/products/comments")
		public ResponseEntity<?> createComment(@RequestBody ProductComments productComment) {
						
			ProductComments nProduct = null;
			Map<String, Object> response = new HashMap<>();
					
			try {
				nProduct = productCommentsService.save(productComment);
			}catch(DataAccessException e) {
				response.put("message", "Error while making the query!");
				response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			response.put("message", "The product was successfully created!");
			response.put("product", nProduct);
			return new ResponseEntity<Map<String, Object>>( response, HttpStatus.CREATED);
		}
		
}
