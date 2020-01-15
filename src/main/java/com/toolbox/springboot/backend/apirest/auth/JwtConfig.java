package com.toolbox.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA ="-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAud/O/qp1YBapQlOkPWN1aF/+4aCvZQD8h0OLSeMKLN9XgJQN\r\n" + 
			"ru2qH9UWxJrmpZKy94eHygSF9tW3NDQTCkG8uNOxqJO/oS3xHBcZrdCflHYHrhFH\r\n" + 
			"rlxfphAb2FFYiohXPkxE++LvZddcVfQ9kRt4agl7CRgpmhUghEFBh4TTXop3H46v\r\n" + 
			"IB1HLOo7vo6Mwhlu3TCv7yqb5sSkXu+biFdEF3RgWnP5RDLFa97p+ifuRikvwRC1\r\n" + 
			"TU2AIXGDyDjFDplVBDrHLkq81YIKws6lmY4tQ+exg7FQ7rNHtUudyxFRlHZ8ODWz\r\n" + 
			"/0fnMzle6j3l0QCHmA1n42XpPN/xUT/xDcUWgwIDAQABAoIBAGC6SKUcndJwWIrM\r\n" + 
			"ribIMFwtwJ04Gq5sUf4uNzkvLqdlXsrpwSksQyEnqh6MIcU+T2YjIJYPvotScnF3\r\n" + 
			"PAVValmgyM5afRnqp5OfrdxXOgRvW9XI5k2lgp0Puv3ab0JAa25fEHMoiL6t0T5l\r\n" + 
			"yPhPnF1KK73y1gt6PR62OtzEUZ7besRdr4ZtpQLAoDCHyuedZ6Y6SlMwafh7AgpD\r\n" + 
			"9WoIMHNoADJ7LAqn7gGGlM3rBCyAuxluz1VgxFK+cFPYXO2ngMTRW9rNhXiXG2Hl\r\n" + 
			"hnqbnUoYZHhdfC/ma3QSuPXOVA7+PCa+pGjSnpS27Lk5443ddss/9chm+ORu2IaF\r\n" + 
			"eM1bvKECgYEA3w6WtguQonaqFJ6UGZU9aAm5tcjMzw03rV7e6FUFgfAauPYrM5f6\r\n" + 
			"tCmoGaBJVzYcmhTEHJULOW6HtG42n3ulA7FMCwbqJvlAcW5hf2ymlnAfGoE8+5Ir\r\n" + 
			"rTb14pGvMs7C7hD5coazn21I1t1peFoNAr36hLcvO8LEwnIhjbYUKpMCgYEA1VNn\r\n" + 
			"JBzVwiA4Ak5BHigXOARiINGAv31Qchmy8xf0YoE9zwk5MVvAn5DcKJzyTuqZ7hKc\r\n" + 
			"HKAWjA9kUZFLSggbvqZZLQBTuaRJE0p/DmExPbcqKLzEVKkUyRiSVDJ5ssNAjR4Y\r\n" + 
			"Jk1u5XQ+1zWufiU1UEmxepIXCWNCWdWfk0sqqlECgYEAhyysIL55dDs9byl6ztYm\r\n" + 
			"VHowVP3PQFreNu6bX2jG4avERfrIy4d6otvrxzvftj5Qrv+OqVOZbcCR9MIl0Bh6\r\n" + 
			"M/aqArS6CcxbRWKDK1mIyvo/nyxa7In0dhAsipWG+t9aOjOHN+RxzlfIII4lcI4B\r\n" + 
			"/Hts6iipMyohW0UXGG4TYokCgYEAxmrt61P6qrZHAjYBMWh+uDazguz6gKGxWn92\r\n" + 
			"x88HGzw03kYo8TTzRDd73zaj1i01gY/DrohkkF+copWu3qwOClU1arr8JRaedZf7\r\n" + 
			"98cFAu9EAmIZhtlBoQ3+xNuyAEjF2LweIDozpK5r6MZgh6paHVR+BJCvZqbxRxeA\r\n" + 
			"doMaqxECgYBcpHgBDr6zxVuQDZ6b4qC1O7f2A1l/Oqa4AGUqXwQGlQxMLFBjm8Ah\r\n" + 
			"aYgrjEuTfSkIjsnZ0+V+tx2f0K87bbRN6gXnyZ9T8pGEZsJlHlAT0p4NmlEAQ+P3\r\n" + 
			"/wsu7eTuna05JYLA5oleId2maTq+VZQ/83IulGOPQ9Zm2JnRBLAN6w==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC ="-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAud/O/qp1YBapQlOkPWN1\r\n" + 
			"aF/+4aCvZQD8h0OLSeMKLN9XgJQNru2qH9UWxJrmpZKy94eHygSF9tW3NDQTCkG8\r\n" + 
			"uNOxqJO/oS3xHBcZrdCflHYHrhFHrlxfphAb2FFYiohXPkxE++LvZddcVfQ9kRt4\r\n" + 
			"agl7CRgpmhUghEFBh4TTXop3H46vIB1HLOo7vo6Mwhlu3TCv7yqb5sSkXu+biFdE\r\n" + 
			"F3RgWnP5RDLFa97p+ifuRikvwRC1TU2AIXGDyDjFDplVBDrHLkq81YIKws6lmY4t\r\n" + 
			"Q+exg7FQ7rNHtUudyxFRlHZ8ODWz/0fnMzle6j3l0QCHmA1n42XpPN/xUT/xDcUW\r\n" + 
			"gwIDAQAB\r\n" + 
			"-----END PUBLIC KEY----";
}
