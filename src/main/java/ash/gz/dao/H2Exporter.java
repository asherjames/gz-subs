package ash.gz.dao;

import org.h2.tools.Csv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@Profile("dev")
@Service
public class H2Exporter implements DbExporter
{
  private static final Logger LOG = LoggerFactory.getLogger(H2Exporter.class);

  private JdbcTemplate jdbcTemplate;

  @Value("${db.export.query}")
  private String exportQuery;

  @Autowired
  public H2Exporter(JdbcTemplate jdbcTemplate)
  {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void exportToOutputStream(OutputStream stream)
  {

  }
}
