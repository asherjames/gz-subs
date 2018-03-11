package ash.gz.repository;

import ash.gz.model.Fund;
import ash.gz.model.Submission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SubmissionRepositoryTest
{
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private SubmissionRepository submissionRepository;

  private String testEmail = "blah@blah.com";

  @Test
  public void testSubmissionCanBeFoundById()
  {
    Submission submission = new Submission();
    submission.setEmail(testEmail);
    submission.setSupportsEnvironment(true);

    UUID id = entityManager.persistAndGetId(submission, UUID.class);
    entityManager.flush();

    Optional<Submission> optional = submissionRepository.findById(id);

    Submission found = null;

    if (optional.isPresent())
    {
      found = optional.get();
    } else
    {
      fail("Submission not found");
    }

    assertThat(found).isNotNull();
    assertThat(found.getId()).isEqualTo(id);
    assertThat(found.getEmail()).isEqualTo(testEmail);
    assertThat(found.isSupportsEnvironment()).isTrue();
  }

  @Test
  public void testSubmissionFundsCanBeFound()
  {
    Submission submission = new Submission();
    submission.setEmail(testEmail);
    submission.setFunds(Stream.of(
        new Fund("Fund_A", true, submission),
        new Fund("Fund_B", false, submission),
        new Fund("Fund_C", true, submission)
    ).collect(Collectors.toList()));

    UUID id = entityManager.persistAndGetId(submission, UUID.class);
    entityManager.flush();

    Optional<Submission> optional = submissionRepository.findById(id);

    Submission found = null;

    if (optional.isPresent())
    {
      found = optional.get();
    } else
    {
      fail("Submission not found");
    }

    assertThat(found).isNotNull();
    assertThat(found.getId()).isEqualTo(id);
    assertThat(found.getFunds())
        .hasSize(3)
        .extracting(Fund::getName)
        .contains("Fund_A", "Fund_B", "Fund_C");
  }

  @Test
  public void testSubmissionCanBeFoundByEmail()
  {
    Submission submission = new Submission();
    submission.setEmail(testEmail);
    submission.setSupportsEnvironment(true);

    entityManager.persistAndFlush(submission);

    List<Submission> submissionList = submissionRepository.findByEmail(testEmail);

    assertThat(submissionList).isNotEmpty();
    assertThat(submissionList).hasSize(1);
    assertThat(submissionList.get(0).getEmail()).isEqualTo(testEmail);
    assertThat(submissionList.get(0).isSupportsEnvironment()).isTrue();
  }
}
