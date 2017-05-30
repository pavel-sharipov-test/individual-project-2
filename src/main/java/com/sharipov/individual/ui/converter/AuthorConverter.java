package com.sharipov.individual.ui.converter;

import com.sharipov.individual.model.Person;
import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.service.PersonService;
import com.sharipov.individual.service.PublisherService;
import com.sharipov.individual.ui.beans.PersonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 22.05.2017
 * Time: 15:21
 */
@Component
@FacesConverter("authorConverter")
public class AuthorConverter implements Converter {

    @Autowired
    private PersonService personService;


    private static final Logger LOG = LoggerFactory.getLogger(AuthorConverter.class);

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                LOG.info(value);
                Person person = personService.find(Long.parseLong(value));
                LOG.info(person.getName());
                return person;
                //return service.find(Long.parseLong(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid author."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            LOG.info(String.valueOf(((Person) value).getId()));
            return String.valueOf(((Person) value).getId());
        } else {
            return null;
        }
    }
}
