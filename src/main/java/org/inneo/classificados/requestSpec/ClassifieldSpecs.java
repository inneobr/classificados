package org.inneo.classificados.requestSpec;

import org.inneo.classificados.modelos.Classified;
import org.springframework.data.jpa.domain.Specification;

public class ClassifieldSpecs {
	
	public static Specification<Classified> isActive(boolean active){
        return (root, query, builder) -> {
        	return builder.equal(root.get("active"), active);
        };
    }
}
