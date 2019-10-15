package netease.spring.boot.study.service;

import netease.jdbc.core.NeteaseJdbcConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhangyb
 * @date 2019-10-15 11:18:44
 */
@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Object find(int userId) throws Exception{
        String sql = "SELECT * FROM USER WHERE ID="+userId;
        Map<String, Object> result = jdbcTemplate.queryForMap(sql);
        return result;
    }
}
