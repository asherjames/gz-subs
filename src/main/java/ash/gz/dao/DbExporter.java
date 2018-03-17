package ash.gz.dao;

import java.io.OutputStream;

public interface DbExporter
{
  void exportToOutputStream(OutputStream stream);
}
