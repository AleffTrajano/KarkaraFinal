package com.gama.passagens.project.model;

import javax.persistence.Column;

import org.hibernate.annotations.Type;

public class Oferta {
	@Type(type = "json")
    @Column(columnDefinition = "json")
    private String properties;
}
