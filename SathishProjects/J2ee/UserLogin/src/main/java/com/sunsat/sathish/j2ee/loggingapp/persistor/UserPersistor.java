package com.sunsat.sathish.j2ee.loggingapp.persistor;

import com.sunsat.sathish.j2ee.loggingapp.pojo.dao.UserDao;
import com.sunsat.sathish.j2ee.loggingapp.pojo.dto.UserDto;
import com.sunsat.sathish.j2ee.loggingapp.util.dao.DaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by ssundar2 on 27-02-2017.
 */
public class UserPersistor {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DaoUtil daoUtil;

    @Autowired
    UserDao uNameDao;

    @Autowired
    UserDto userDto;

    public void addNewUser(UserDto userDto) {
        int id  = daoUtil.getMaxUserId();
        uNameDao.setPassword(userDto.getPassword());
        uNameDao.setId(id+1);
        uNameDao.setUesrName(userDto.getUesrName());
        uNameDao.setCreationTime(new Date());
        uNameDao.setExpiryTime(new Date());
        uNameDao.setStauts("Initial");
        String sql = "insert into users (id,username,password,creationdate,expirydate,status) values (?,?,?,?,?,?)";
        Object[] paramsObj = {uNameDao.getId(), uNameDao.getUesrName(), uNameDao.getPassword(), uNameDao.getCreationTime(), uNameDao.getExpiryTime(), uNameDao.getStauts()};
        jdbcTemplate.update(sql,paramsObj);
    }

    public void updateUser(UserDto userDto) {
        uNameDao.setId(userDto.getId());
        uNameDao.setPassword(userDto.getPassword());
        uNameDao.setUesrName(userDto.getUesrName());
        uNameDao.setCreationTime(new Date());
        uNameDao.setExpiryTime(new Date());
        uNameDao.setStauts("verified");
        String sql = "update users SET username=?,password=?,creationdate = ?,expirydate=?,status=? where id=?" ;
        Object[] paramsObj = {uNameDao.getUesrName(), uNameDao.getPassword(), uNameDao.getCreationTime(), uNameDao.getExpiryTime(), uNameDao.getStauts(),uNameDao.getId()};
        jdbcTemplate.update(sql,paramsObj);
    }

    public void deleteUser() {

    }

    public UserDto getUserByName(String userName) {
        String sql = "select * from users where username = ?";
        UserDao dao = jdbcTemplate.queryForObject(sql, new String[]{userName}, new UserRowMapper());
        userDto.setUesrName(dao.getUesrName());
        userDto.setId(dao.getId());
        userDto.setPassword(dao.getPassword());
        userDto.setCreationTime(dao.getCreationTime());
        userDto.setStauts(dao.getStauts());
        userDto.setExpiryTime(dao.getExpiryTime());
        return userDto;
    }

    public UserDto getUserById(int id) {
        String sql = "select * from users where id = ?";
        UserDao dao = jdbcTemplate.queryForObject(sql, new Integer[]{id}, new UserRowMapper());
        userDto.setUesrName(dao.getUesrName());
        userDto.setId(dao.getId());
        userDto.setPassword(dao.getPassword());
        userDto.setCreationTime(dao.getCreationTime());
        userDto.setStauts(dao.getStauts());
        userDto.setExpiryTime(dao.getExpiryTime());
        return userDto;
    }

    class UserRowMapper implements RowMapper<UserDao> {
        public UserDao mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDao udao = new UserDao();
            udao.setId(rs.getInt("id"));
            udao.setUesrName(rs.getString("username"));
            udao.setPassword(rs.getString("password"));
            udao.setCreationTime(rs.getDate("creationdate"));
            udao.setExpiryTime(rs.getDate("expirydate"));
            udao.setStauts(rs.getString("status"));
            return udao;
        }
    }
}
