package com.sharipov.individual.ui.converter;

import com.sharipov.individual.model.Person;
import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.service.PersonService;
import com.sharipov.individual.ui.beans.PersonBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 22.05.2017
 * Time: 15:21
 */
@FacesConverter("authorConverter")
public class AuthorConverter implements Converter{

    @Autowired
    private PersonService personService;




    /*    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ValueExpression valueExpression = context.getApplication().getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{personBean}", PersonBean.class);
        PersonBean person = (PersonBean) valueExpression.getValue(context.getELContext());
        return person.getPersonbyId(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Person) value).getId().toString();
    }*/

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       Person person = personService.find(Long.parseLong(value));
        return person;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value.getClass().equals(Person.class)) {
            return ((Person) value).getId().toString();
        } else {
            return null;
        }
    }
}
