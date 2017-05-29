package com.sharipov.individual.ui.converter;

import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.service.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

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
    private PublisherService publisherService;

    private static final Logger LOG = LoggerFactory.getLogger(PublisherConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                /*PublisherService service = (PublisherService) context.getExternalContext().getApplicationMap().get("publisherService");
                Publisher publisher = service.find(Long.parseLong(value));*/
                LOG.info(value);
                Publisher publisher =  publisherService.find(Long.parseLong(value));
                LOG.info(publisher.getName());
                return publisher;
                //return service.find(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid publisher."));
            }
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null) {
            LOG.info(String.valueOf(((Publisher) value).getId()));
            return String.valueOf(((Publisher) value).getId());
        }
        else {
            return null;
        }
    }


    /*    @Autowired
    private PublisherService publisherService;

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
    }*/
}
