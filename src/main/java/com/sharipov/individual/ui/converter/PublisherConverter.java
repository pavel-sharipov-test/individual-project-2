package com.sharipov.individual.ui.converter;

import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 22.05.2017
 * Time: 15:28
 */

@Component
@FacesConverter("publisherConverter")
public class PublisherConverter implements Converter {

    @Autowired
    PublisherService publisherService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return publisherService.find(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value.getClass().equals(Publisher.class)) {
            return ((Publisher) value).getId().toString();
        } else {
            return null;
        }
    }
}
