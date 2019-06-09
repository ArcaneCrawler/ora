package com.math.epidemic.Entities.Mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import com.math.epidemic.Entities.Virus;
import org.springframework.jdbc.core.RowMapper;

public class VirusMapper implements RowMapper<Virus> {

    public static final String FindName //
            = "Select name From Virus ";

    @Override
    public Virus mapRow(ResultSet rs, int rowNum) throws SQLException {

       // Long id = rs.getLong("Id");
        String name = rs.getString("name");

        return new Virus(name);
    }

}