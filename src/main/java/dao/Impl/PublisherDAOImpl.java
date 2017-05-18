package dao.Impl;

import dao.PublisherDAO;
import model.Publisher;

/**
 * Created with IntelliJ IDEA
 * Author: Pavel Sharipov
 * Date: 18.05.2017
 * Time: 13:19
 */
public class PublisherDAOImpl extends BaseEntityDAOImpl<Publisher> implements PublisherDAO {
    public PublisherDAOImpl() {
        super(Publisher.class);
    }
}
