public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
    boolean existsByCategoryName(String name);
}
