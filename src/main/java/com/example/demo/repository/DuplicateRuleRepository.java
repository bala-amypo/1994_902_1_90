public interface DuplicateRuleRepository extends JpaRepository<DuplicateRule, Long> {
    DuplicateRule findByRuleName(String name);
}
