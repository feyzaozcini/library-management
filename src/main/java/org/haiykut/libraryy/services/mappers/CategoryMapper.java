package org.haiykut.libraryy.services.mappers;

import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryAddRequestDto;
import org.haiykut.libraryy.services.dtos.requests.category.CategoryUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category categoryFromRequest(CategoryAddRequestDto request);

    Category categoryFromRequest(CategoryUpdateRequestDto request);

}
