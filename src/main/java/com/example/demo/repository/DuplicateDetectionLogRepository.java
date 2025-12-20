public interface DuplicateDetectionLogRepository extends JpaRepository<DuplicateDetectionLog, Long> {
    List<DuplicateDetectionLog> findByTicket_Id(Long id);
}
