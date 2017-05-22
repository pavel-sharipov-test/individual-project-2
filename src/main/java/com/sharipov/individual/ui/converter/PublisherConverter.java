package com.sharipov.individual.ui.converter;

import com.sharipov.individual.model.Publisher;
import com.sharipov.individual.ui.beans.BookBean;
import com.sharipov.individual.ui.beans.PublisherBean;

import javax.el.ValueExpression;
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
@FacesConverter("publisherConverter")
public class PublisherConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ValueExpression valueExpression = context.getApplication().getExpressionFactory()
                .createValueExpression(context.getELContext(), "#{publisherBean}", PublisherBean.class);
        PublisherBean publisher = (PublisherBean) valueExpression.getValue(context.getELContext());
        return publisher.getPublisherbyId(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Publisher) value).getId().toString();
    }
}
