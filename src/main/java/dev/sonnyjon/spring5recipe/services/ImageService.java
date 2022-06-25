package dev.sonnyjon.spring5recipe.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Sonny on 6/13/2022.
 */
public interface ImageService
{
    void saveImageFile(Long recipeId, MultipartFile file);
}
