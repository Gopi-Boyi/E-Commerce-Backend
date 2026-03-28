package com.E.Commerce.Backend.Service;

import com.E.Commerce.Backend.Dto.ProductDto;
import com.E.Commerce.Backend.Dto.ProductListDto;
import com.E.Commerce.Backend.Exception.ResourceNotFoundException;
import com.E.Commerce.Backend.Mapper.ProductMapper;
import com.E.Commerce.Backend.Model.Product;
import com.E.Commerce.Backend.Repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;



    private static final String UPLOAD_DIR = "src/main/resources/static/images";

    //CREATING THE PRODUCT
    @Transactional
    public ProductDto createProduct(ProductDto productDto, MultipartFile image) throws IOException{
        Product product =productMapper.toEntity(productDto);
        if(image != null && !image.isEmpty()){
            String fileName = saveImage(image);
            product.setImage("/image"+fileName);//TO SAVE IMAGE PATH IN DB
        }
        Product savedProduct=productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Transactional
    public ProductDto updateProduct(Long id, ProductDto productDto, MultipartFile image)throws IOException{
        Product exitingProduct=productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        exitingProduct.setName(productDto.getName());
        exitingProduct.setDescription(productDto.getDescription());
        exitingProduct.setPrice(productDto.getPrice());
        exitingProduct.setQuantity(productDto.getQuantity());
        if(image != null && !image.isEmpty()){
            String fileName = saveImage(image);
            exitingProduct.setImage("/image"+fileName);
        }
        Product updateProduct = productRepository.save(exitingProduct);
        return productMapper.toDto(updateProduct);
    }

    @Transactional
    public void deleteProduct(Long id){
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product Not Found");
        }
        productRepository.deleteById(id);
    }

    public ProductDto getProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        return productMapper.toDto(product);
    }

    public List<ProductListDto> getAllProducts(){
        return productRepository.findAllWithoutComments(); //fix for comments
    }

    private String saveImage(MultipartFile image) throws IOException{
        String fileName = UUID.randomUUID().toString()+"_"+image.getOriginalFilename();
        Path path = Paths.get(UPLOAD_DIR + "/" + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, image.getBytes());
        return fileName;
    }
}
