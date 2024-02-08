package org.inneo.classificados.requestSpec;

import org.inneo.classificados.modelos.Category;
import org.springframework.data.jpa.domain.Specification;

public class CategorySpecs {
	public static Specification<Category> isActive(boolean active){
        return (root, query, builder) -> {
        	return builder.equal(root.get("active"), active);
        };
    }
}
