package ash.gz.resource;

import ash.gz.dao.DbExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class DatabaseExportResource
{
  private static final Logger LOG = LoggerFactory.getLogger(DatabaseExportResource.class);

  private DbExporter dbExporter;

  @Autowired
  public DatabaseExportResource(DbExporter dbExporter)
  {
    this.dbExporter = dbExporter;
  }

  @RequestMapping("/export")
  public void exportCsv(HttpServletResponse response)
  {
    try
    {
      dbExporter.exportToOutputStream(response.getOutputStream());
    }
    catch (IOException e)
    {
      LOG.error("IOException encountered while getting servlet response output stream", e);
    }
  }
}
