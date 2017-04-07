package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hyunki on 2017. 3. 31..
 */
public class AddUserStatement implements StatementStrategy {
    private User user;

    public AddUserStatement(User user) {
        this.user = user;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("insert into userinfo(name, password) VALUES (?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        return preparedStatement;
    }
}
