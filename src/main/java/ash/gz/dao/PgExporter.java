package ash.gz.dao;

import org.postgresql.copy.CopyManager;
import org.postgresql.jdbc.PgConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@Profile("prod")
@Service
public class PgExporter implements DbExporter
{
  private static final Logger LOG = LoggerFactory.getLogger(PgExporter.class);

  private JdbcTemplate jdbcTemplate;

  @Value("${db.export.query}")
  private String exportQuery;

  @Autowired
  public PgExporter(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void exportToOutputStream(OutputStream stream)
  {
    try(Connection connection = jdbcTemplate.getDataSource().getConnection())
    {
      if(!connection.isWrapperFor(PgConnection.class))
      {
        throw new RuntimeException("Connection is not wrapper for PgConnection class");
      }

      PgConnection pgConnection = connection.unwrap(PgConnection.class);

      CopyManager copyManager = new CopyManager(pgConnection);

      copyManager.copyOut(exportQuery, stream);
    }
    catch (SQLException sqle)
    {
      LOG.error("SQLException encountered while getting DB connection", sqle);
    }
    catch (IOException ioe)
    {
      LOG.error("IOException encountered while writing CSV to output stream", ioe);
    }
  }
}
