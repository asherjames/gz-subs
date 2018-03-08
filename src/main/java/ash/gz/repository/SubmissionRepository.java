package ash.gz.repository;

import ash.gz.model.Submission;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubmissionRepository extends PagingAndSortingRepository<Submission, Long>
{
  List<Submission> findByEmail(@Param("email") String name);
}
