package ash.gz.resource;

import ash.gz.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubmissionCountResource
{
  private final SubmissionRepository submissionRepository;

  @Autowired
  public SubmissionCountResource(SubmissionRepository submissionRepository)
  {
    this.submissionRepository = submissionRepository;
  }

  @RequestMapping("/count")
  public String getCount()
  {
    return "Total submissions: " + submissionRepository.count();
  }
}
