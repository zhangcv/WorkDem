package com.example.demo.service.impl;

import com.example.demo.entity.Commodity;
import com.example.demo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Creacted by jack on 2019/9/30 14:28
 **/
@Service
public class CommodityServiceImpl  implements CommodityService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Commodity commodity) {
        String sql = "insert into commodity(com_name,com_price,com_description) values(?,?,?)";
        Object[] params = {commodity.getCom_name(),commodity.getCom_price(),commodity.getCom_description()};

        return jdbcTemplate.update(sql,params);
    }

    @Override
    public int delete(Long id) {
        String sql = "delete from commodity where com_id =?";

        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(Commodity commodity) {
        String sql = "update commodity set com_name=?,com_price=?,com_description=? where com_id = ?";
        Object[] params ={commodity.getCom_name(),commodity.getCom_price(),commodity.getCom_description(),
                commodity.getCom_id()};
        return jdbcTemplate.update(sql,params);
    }

    @Override
    public int updateName(Commodity commodity) {
        String sql = "update commodity set com_name=? where com_id = ?";
        Object[] params ={commodity.getCom_name(),commodity.getCom_id()};
        return jdbcTemplate.update(sql,params);
    }

    @Override
    public Commodity findOne(Long id) {
        String sql ="select * from commodity where com_id =?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Commodity.class));
    }

    @Override
    public List<Commodity> findAll() {
        String sql = "select * from commodity";
        return jdbcTemplate.query(sql, new CommodityMapper());


    }
    class CommodityMapper implements RowMapper<Commodity>{
        @Override
        public Commodity mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("com_id");
            String name = rs.getString("com_name");
            String price = rs.getString("com_price");
            String description = rs.getString("com_description");

            Commodity commodity = new Commodity();
            commodity.setCom_id(String.valueOf(id));
            commodity.setCom_name(price);
            commodity.setCom_description(description);

            return commodity;
        }
    }
}