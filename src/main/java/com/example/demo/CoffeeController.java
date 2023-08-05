package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins="*")
public class CoffeeController {
	@Autowired
	CoffeeRepo coffeeRepo;
	
	@GetMapping("/coffee/find")
	public Coffee findById(@RequestParam int id) {
		
		
		 Coffee coffee =coffeeRepo.findById(id).get();
		 
		 coffee.setImage(decompressBytes(coffee.getImage()));
		 
		 return coffee;
		
	}
	
	@PostMapping("/coffee/add")
	public String addProduct(@RequestParam ("dietFile") MultipartFile myFile,
			String coffeename,
			String flavour,
			String quantity,
			String caffeinecontent,
			String price,
			String discount) {
		
		try {
			Coffee prdImage = new Coffee(coffeename,flavour,quantity,caffeinecontent,price,discount,
					compressBytes(myFile.getBytes()));
			System.out.println(prdImage);
			coffeeRepo.save(prdImage);		
		}catch(Exception e) {
			
		}
		
		
		
		return "Successfully Added New Product";
		
	}
	
	@GetMapping("/coffee/delete")
	public List<Coffee> deleteDoctor(@RequestParam int id){
		
		coffeeRepo.deleteById(id);
		
		return getAllProducts();
	}
	@GetMapping("/coffee/all")
	public List<Coffee> getAllProducts(){
		
		List<Coffee> drList = new ArrayList<Coffee>();
		
		List<Coffee> resDrList = coffeeRepo.findAll();
		Coffee coffee = null;
		for(int i=0;i<resDrList.size();i++) {
			
			coffee= resDrList.get(i);
			
			coffee.setImage(decompressBytes(coffee.getImage()));
			
			drList.add(coffee);
			
		}
		
		
		return drList;
	}
	
	// compress the image bytes before storing it in the database
			public static byte[] compressBytes(byte[] data) {
				Deflater deflater = new Deflater();
				deflater.setInput(data);
				deflater.finish();

				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				while (!deflater.finished()) {
					int count = deflater.deflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				try {
					outputStream.close();
				} catch (IOException e) {
				}
				System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

				return outputStream.toByteArray();
			}

			// uncompress the image bytes before returning it to the angular application
			public static byte[] decompressBytes(byte[] data) {
				Inflater inflater = new Inflater();
				inflater.setInput(data);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				try {
					while (!inflater.finished()) {
						int count = inflater.inflate(buffer);
						outputStream.write(buffer, 0, count);
					}
					outputStream.close();
				} catch (IOException ioe) {
				} catch (DataFormatException e) {
				}
				return outputStream.toByteArray();
			}


}
