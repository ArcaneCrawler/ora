package com.math.epidemic.Entities;


        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;

        import javax.sql.DataSource;


public class VirusDAOImp implements VirusDAO
{
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Virus virus){

     /*   String sql = "INSERT INTO virus " +
                "(ID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getAge());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }*/
    }

    public Virus findById(int id){

        String sql = "SELECT * FROM virus WHERE id = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Virus virus = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                virus = new Virus();
                virus.setId(rs.getLong("id"));
                virus.setName(rs.getString("name"));
                virus.setStrain(rs.getString("strain"));
                virus.setLethal(rs.getFloat("lethal"));
                virus.setInfluence(rs.getFloat("influence"));
                virus.setChance(rs.getFloat("chance"));
                virus.setEvol_rate(rs.getFloat("evol_rate"));
                virus.setCure_rate(rs.getFloat("cure_rate"));
                virus.setEndurance(rs.getFloat("endurance"));
            }
            rs.close();
            ps.close();
            return virus;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}