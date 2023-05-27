SELECT 'Project A' AS name, MAX(months) AS month_count FROM (
   SELECT DATEDIFF(
   'MONTH', start_date, finish_date) as months
   FROM project);