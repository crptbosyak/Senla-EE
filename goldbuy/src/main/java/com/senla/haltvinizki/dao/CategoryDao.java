package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.category.Category;

public interface CategoryDao extends GenericDao<Category,Integer> {
    Category getCategoryWithProduct(int id);


}
