/***
 * Set of formatting rules  
 * https://vadimtropashko.wordpress.com/2017/01/03/custom-formatting-in-sqldev-4-2/
***/

/**
 * simpleIndentConditions  
 * Parse nodes to be indented with simple conditions, typically parse node payload, e.g.
   [node) select_term                               --<-- all parse nodes with "select_term" payload
   [node) expr  &  [node^) simple_case_expression   --<-- parse nodes with "expr" payload, whose parent (i.e. node^) is labeled "simple_case_expression"
   [node) condition  & [node-1) 'WHEN'              --<-- parse nodes with "condition" payload, whose sibling predecessor (i.e. node-1) is keyword WHEN             --
**/
simpleIndentConditions:  
  [node) ',' & [node+1) cell_assignment
| [node) ',' & [node^) object_properties
| [node) 'ALL' & [node+1) 'ON'
| [node) 'FOR' & [node^) explain_plan
| [node) 'INTO' & [node^) call_statement
| [node) 'PARTITION' & [node^) on_comp_partitioned_table[68,117)# 
| [node) 'UPDATE' & [node-1) 'THEN' & ! [node-1-1) 'MATCHED'
| [node) adt_field_list & [node-1) '('
| [node) aggregate_function  & [node^) pivot_clause
| [node) alias_in_out_constraints & [node^) create_view#[76,92)
     | [node) create_view#[79,86) & [node^) create_view#[76,92)
| [node) alter_method_spec 
| :breaksProcArgs & [node) arg & [node^) paren_expr_list & [node+1) arg_list
| :breaksProcArgs & [node) arg_list & [node^) paren_expr_list & [node-1) arg
--| :breaksProcArgs & [node) ',' & [node^) arg_list & [node+1) arg
| [node) array_ty_def
| [node) attr_dim_hierarchy 
| [node) attribute_clause 
| [node) autoextend_clause 
| [node) basic_decl_item   -- individual declarations glued together 
                           -- same effect as: [node) basic_decl_item_list & [node^) decl_list
                           -- with additional line breaks
| [node) binding_clause
| [node) bitmap_join_index_clause
| [node) build_clause
| [node) bulk_executable_stmt
| :breaksAfterSelectFromWhere & [node) cartesian_product  &  [node^) from_clause 
| [node) case_expr & ![node^) pls_expr     -- e.g. IF CASE a WHEN 3 THEN 4 ELSE a END > 7 THEN ...
                                           --         ^^^^^^^^^^^^^^ pls_expr ^^^^^^^^^^^
| [node) case_expr_alt
--| [node) case_expression & ![node^) select_term   
-- Causes awkward alignment:
-- select    
--         CASE
--            WHEN e.salary > 10000 THEN e.salary
--            ELSE 2000
--         END 
--     salary,
--     ...
| [node) case_stmt_alt
| [node) cell_reference_options 
| [node) cluster_range_partitions 
| [node^) comment & [node) string_literal
| [node) comparison_condition & [node^) bitmap_join_index_clause
| :breakAfterWhen &  [node) condition  &  [node-1) 'WHEN'
| [node) column   & [node+1) insert_into_clause[16,23)
--| [node) compound_condition  &  [node-1) '(' & ![node^^) on_using_condition
--| :breaksBeforeLogicalConjunction & :breaksAfterLogicalConjunction &  [node) condition  & ( [node-1) AND_OR | [node+1) AND_OR ) 
-- ^^^^^^^ nests conditions; indent keywords instead
| :breaksBeforeLogicalConjunction & :breaksAfterLogicalConjunction &  [node) AND_OR & ( [node-1) condition | [node+1) condition )
--excessive nesting for compound conditions: | :breaksAfterSelectFromWhere &  [node) condition  &  [node^)  compound_condition & ![node) compound_condition & [node^ = [node
| :breaksAfterSelectFromWhere  & [node) condition  &  [node^) having_clause & ![node) compound_condition
| [node) condition  &  [node^) hierarchical_query_clause & ![node) compound_condition
| :breaksAfterSelectFromWhere   & [node) condition  &  [node^) where_clause 
| [node) conditional_insert_clause
| [node) conditional_insert_clause[58,99)#
| [node) constraint_clauses & [node+10 < node) 
| [node) create_cluster[41,70)#
| [node) create_cluster[71,143)#
| [node) create_database[15,196)# 
| [node) create_index_statement & ![node^) sql_statement
| [node) create_mv_refresh 
| [node) create_mv_refresh[12,248)# 
| [node) cycle_clause
| [node) database_logging_clauses
| [node) database_logging_clauses[24,42) 
| [node) datafile_tempfile_spec 
| [node) dblink_authentication 
| [node) "db_link_auth" 
| [node) default_tablespace
| [node) dependent_handling_clause 
| [node) dimension_join_clause 
| [node) dml_event_clause
| [node) else_clause
| [node) else_clause_opt & ![node^) if_stmt
| [node) ELSE_expr_opt
| [node) enable_pluggable_database 
| [node) error_logging_clause
| [node) et_field_spk
| [node) excptn_handler
| [node) export_keys[69,95) 
--| [node) expr  &  [node^) xmlelement[58,78)
| [node) expr  &  [node+1) par_expr_list[17,35)
| [node-1) expr  &  [node) par_expr_list[17,35)
| :breakAfterCase &  [node) expr  &  [node^) simple_case_expression
| :breakAfterElse &  [node) expr  &  [node-1) 'ELSE'
| :breakAfterThen &  [node) expr  &  [node-1) 'THEN'
| :breakAfterWhen &  [node) expr  &  [node-1) 'WHEN'
| :breaksProcArgs &  [node) "expr_list" & [node^) "(x,y,z)" & ![node) compound_expression & ![node) identifier
| [node) expression_list  & ![node) grouping_expression_list
| [node) external_table_data_props 
| [node) fields_def
| [node) file_name_convert
| [node) file_specification
| :breaksAfterSelectFromWhere &  [node) group_by_list
| [node) hierarchy_clause 
| [node) hierarchy_clause[14,29)#
| [node) identifier & [node+1) colmapped_query_name[8,15) 
| [node) identifier  & [node^) colmapped_query_name[8,15) 
       | [node) ','  & [node^) colmapped_query_name[8,15) 
| [node) identifier & [node^) create_materialized_view[33,79)
| [node) identifier & [node^) create_materialized_view[53,77)
| [node) identity_clause
| [node) index_properties & [node^) table_index_clause
| [node) index_subpartition_clause[69,119)# 
| [node) inline_constraint & ![node) inline_constraint[14,67)
| [node) inline_ref_constraint
| [node) insert & ![node^) sql_statement & ![node^) stmt                         -- insert without trailing semicolon
| [node) insert_into_clause & ![node^) single_table_insert & ![node^) multi_table_insert[12,24)#
| [node) insert_into_clause[16,23) & [node-1) column
| [node) java_call_specification
| [node) JSON_column_definition
| [node) JSON_columns_clause 
| [node) JSON_value_column 
| [node) json_name_value_pair
| [node) json_object
| [node) json_table 
| [node) key_management_clauses 
| [node) keystore_management_clauses 
| [node) level_clause 
| [node) list_partitions[68,90)#
| [node) listagg & ![node^) select_term
| [node) LOB_storage_clause
| [node) LOB_storage_parameters#
| [node) local_partitioned_index
| [node) logfile_clause
| [node) model_column_clauses 
| [node) model_rules_clause
| [node) merge_into_new_keystore[35,47)
-- no indent, brk only: | [node) merge_insert_clause
| [node) merge_insert_clause[43,55)
| [node) column & [node+1) merge_insert_clause[25,32)
-- no indent, brk only: | [node) merge_update_clause
| [node) mining_attribute_clause & [node+2 < node) 
| [node) modify_col_properties
| [node) modify_col_visibility
| [node) "mv_log_details"
| [node) name & [node^) name_list
| [node) nested_table_col_properties  & ![node)column_properties#  --  nested_table_col_properties->column_properties#->column_properties 
| [node) column_properties  & [node^) nested_table_col_properties[49,69) 
| [node) new_values_clause 
| [node) object_privilege & [node+1) 'ON'
| [node) object_properties & ![node^) object_properties
| [node) object_view_clause
| [node) order_by_clause & 
             ([node^) aggregate_function | [node^) analytic_function | [node^) analytic_clause | [node^^) analytic_clause) --<-- not to ident order by in the main query block 
| :breaksAfterSelectFromWhere & [node) "ord_by_1desc" & [node^) order_by_clause 
| :breaksAfterSelectFromWhere & [node) order_by_clause[31,38) & [node^) order_by_clause
| [node) original_method_body_specification
| [node) parallel_clause 
| [node) password_parameters
| [node) pdb_storage_clause
| [node) pivot_for_clause 
| [node) pivot_in_clause
| :breakAfterWhen &  [node) pls_expr  &  [node-1) 'WHEN'
| :breakAfterThen &  [node) pls_expr  &  [node-1) 'THEN'
| :breakAfterElse &  [node) pls_expr  &  [node-1) 'ELSE'
| :breakAfterIf   & [node) pls_expr & [node^) nonblock_compound_stmt  -- e.g. IF CASE a WHEN 3 THEN 4 ELSE a END > 7 THEN ...
                                                                      --         ^^^^^^^^^^^^^^ pls_expr ^^^^^^^^^^^
| [node) privilege_audit_clause 
| [node) parm_list_opt &  [node^) fml_part  
| [node) prm_spec &       [node^) fml_part  
| [node) query_partition_clause --& [node^) analytic_clause
| [node) range_values_clause 
| [node) record_format 
| [node) record_format2
| [node) relational_properties
| [node) ref_cls
| [node) references_clause 
| [node) references_clause[28,59)
| [node) referencing_clause
| :breaksBeforeLogicalConjunction & :breaksAfterLogicalConjunction & [node) rel  & ( [node-1) AND_OR | [node+1) AND_OR ) 
| :breakAfterIf    & [node) rel & [node^) if_stmt
| :breakAfterElsif & [node) rel & [node^) elsif_clause_opt
| :breakAfterWhile & [node) rel & [node^) iteration_scheme
| [node) resource_parameters 
| [node) role_audit_clause
| [node) rowOpt
| [node) row_pattern_definition 
| [node) row_pattern_measure_column 
| [node) row_pattern_measures 
| [node) row_pattern_order_by 
| [node) row_pattern_partition_by 
| [node) row_pattern_rows_per_match 
| [node) row_pattern_skip_to
| [node) search_clause
| [node) searched_case_expression#
| [node) security_clauses
| :breaksAfterSelectFromWhere & [node) select_list & [node^) select_clause 
| [node) simple_case_expression[4,27)#
| [node) single_column_for_loop
| [node) source_file_name_convert 
| [node) standard_actions 
| [node) stmt & ![node^) sqlplus_command 
--| :breakAfterThen & [node) stmt  &  [node-1) 'THEN'
| [node) storage_clause 
| [node) subpartition_by_hash
| [node) subpartition_template
| [node) subpartition_template[24,31)
| [node) subprg_body & ![node^) create_plsql & ![node^) original_method_body_specification  --&  ! [node^) create    ++683(684?)
| [node) subprg_property
| [node) subprogram_spec 
| :breakOnSubqueries &  [node) subquery &  [node-1) '(' &  [node+1) ')'
| [node) subquery  & [node-1) 'AS'                -- sql_statement+create_view
| [node) query_block  & [node-1) 'AS'                -- create_materialized_zonemap
| [node) query_block  & [node^) merge[47,60)                
| [node) subquery  & [node-1) insert_into_clause
| [node) system_privilege 
| [node) table_index_clause 
| [node) table_partitioning_clauses
| [node) table_properties  & ![node) column_properties          --?or relational_table  extra ident for ++1222  
                                                                -- &! [node) nested_table_col_properties
| [node) table_stmt -- for compound trigger
| [node) tablespace_clauses 
| [node) tablespace_datafile_clauses 
| [node) tempfile_reuse_clause
| [node) type_constructor_expression &  ! [node^) create
| :breaksAfterSelectFromWhere & [node) update_set_clause_expr & [node^^) update_set_clause
| [node) update_set_clause_expr & ![node^^) update_set_clause
| [node) user_aux
| [node) using_clause_opt
| [node) using_index_clause 
| [node) values_clause & ([node^) conditional_insert_clause[58,99)# | [node^) conditional_insert_clause)
| [node) virtual_column_definition
| [node) when_condition
| [node) windowing_clause /*can be up 2 levels: & [node^) analytic_clause*/
/*| [node) xmlelement & ![node^) select_term  
| [node) xmlelement[41,54)
| [node) XMLnamespaces_clause
| [node-1-1) XMLnamespaces_clause & [node) string
| [node) XMLnamespaces_clause[35,63)
| [node) XMLTABLE_options
| [node) XMLSchema_spec
| [node) XMLType_storage 
| [node) XML_attributes_clause 
| [node) XML_table_column
*/ 
| [node) aux_xml_value_expr           & [node^) XML_attributes_clause
| [node) XML_attributes_clause[31,38) & [node^) XML_attributes_clause
| [node) xmlelement[41,54)     & [node^) XML_function
| [node) ','                   & [node^) XML_function
| [node) XML_attributes_clause & [node^) XML_function
| [node) xmlelement[58,78) & [node^) XML_function
-- User-specific: INTO l_var
| [node) identifier  &  [node^) into_list
;

/**
 * More elaborate condition on parse nodes to be indented.
 * It specifies a constraint upon the node itself together with condition upon some ancestor.
 * For example, 
   [node) column  &  [ancestor) insert_into_clause  --<-- parse nodes with "column" payload, whose ancestor is labeled "insert_into_clause"  
**/ 
closestAncestorDescendent:
ancestor < node & ![node^) "(x,y,z)" & [node) column  & (
   [ancestor) attribute_clause                  & ![node^) compound_expression
 | [ancestor) dimension_join_clause             & ![node^) compound_expression
 | [ancestor) extended_attribute_clause         & ![node^) compound_expression
 | [ancestor) table_index_clause                & ![node^) compound_expression
 | [ancestor) range_partitions 
 | [ancestor) range_values_clause 
);


indentedNodes1: simpleIndentConditions | closestAncestorDescendent
->
;

/**
 * This is the same set of nodes as indentedNodes1
 * This duplicate relation is warranted for second callback 
**/ 
indentedNodes2: indentedNodes1
->
;



"built-ins":
    [identifier) identifier 
  & [call) analytic_function
  & [call = [identifier
-- | [identifier) 'TO_CHAR' -- not in grammar
;
"ids": --node) <= [node + 1
   [identifier) identifier 
;
identifiers: "ids" - "built-ins"
-> 
;

/**
 * Formal condition when to insert extra line breaks.
 * This condition is for those line breaks which are not part of indentation 
 * Not to be confused with condition when to insert double breaks (AKA "brkX2").
 * The extra break is inserted _before_ the "node"
**/
_extraBrkBefore: 
  [node) physical_properties 
| [node) sql_statement & ![node^) identifier  -- if there is a parent of sql_statement with any payload (identifiers are always leaf nodes) 
| [node) from_clause 
| [node) where_clause 
| [node) into_list
| [node) group_by_clause 
| [node) having_clause 
| [node) order_by_clause 
| [node) row_limiting_clause
| [node) model_clause 
| [node) segment_attributes_clause & ![node^) segment_attributes_clause
| :breaksBeforeComma &  [node+1) alias_in_out_constraints           & [node) ','
| :breaksBeforeComma &  [node+1) select_term           & [node) ','
| :breaksBeforeComma &  [node+1) table_reference       & [node) ','
| :breaksBeforeComma &  [node^) order_by_clause[31,38) & [node) ','
| :breaksBeforeComma &  [node^) group_by_list[5,12)    & [node) ','
| :breaksBeforeComma &  [node+1) expr                  & [node) ','
| :breaksBeforeComma &  [node+1) column                & [node) ','
| :breaksBeforeComma &  [node+1) col_properties        & [node) ','
--| [node) column & [node+1) insert_into_clause[16,23)
--| [node) column_properties & ! [node^) column_properties --?++5 & ! [node^) relational_table
| :breaksBeforeComma &  [node^) colmapped_query_name[8,15)        & [node) ','
| :breaksBeforeComma &  [node+1) field                 & [node) ','
| :breaksBeforeComma &  [node+1) prm_spec              & [node) ','
| :breaksBeforeComma &  [node+1) XML_attributes_clause        & [node) ','
| :breaksBeforeConcat &  [node+1) '|'                  & [node) '|'               
                      &  ( [node^^^) compound_expression | [node^^^) arith_expr | [(node^^)+10 < (node^^)) | [(node^-1)+3 < (node^-1)) ) 
                      --^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
                      -- break long concatenation lists like this:
                      --     dbms_output.put_line(emp_first_name
                      --                            || ' '
                      --                            || emp_last_name);
                      -- while keeping short ones inline:
                      --     dbms_output.put_line('hello' || 'world');
| :breaksBeforeLogicalConjunction &  [node+1) condition  & [node) AND_OR  
| :breaksBeforeLogicalConjunction &  [node+1) rel        & [node) AND_OR
| [node) "inner_cross_join_clause"
| [node) "outer_join_clause"
| :breakAnsiiJoin &  [node) on_using_condition
| [node) merge_insert_clause  
| [node) merge_update_clause
| [node) 'BEGIN'  & [node^) subprg_body 
| [node) 'NESTED' & [node^) column_properties
| [node) 'MEASURES' --& [node^) model_column_clauses
| [node) '(' & [node+1) cell_assignment --& [node^) model_rules_clause
| [node) update_set_clause
;

_extraBrkAfter: 
   [node) sql_statement & [node^) sql_statements
|  [node) basic_decl_item
|  [node) stmt & ![node^) sqlplus_command 
| :breaksAfterComma &  [node+1) alias_in_out_constraints           & [node) ','
| :breaksAfterComma &  [node+1) select_term           & [node) ','
| :breaksAfterComma &  [node+1) table_reference       & [node) ','
| :breaksAfterComma &  [node^) order_by_clause[31,38) & [node) ','
| :breaksAfterComma &  [node^) group_by_list[5,12)    & [node) ','
| :breaksAfterComma &  ([node+1) expr  | [node+1) column)               & [node) ',' 
                             & ![node^) aggregate_function & ![node^) analytic_function
                             -- & ... -- unable to keep (x,y) inline without referring to ancestor    
| :breaksAfterComma &  [node+1) col_properties        & [node) ','
| :breaksAfterComma &  [node^) colmapped_query_name[8,15)        & [node) ','
| :breaksAfterComma &  [node+1) field                 & [node) ','
| :breaksAfterComma &  [node+1) prm_spec              & [node) ','
| :breaksAfterComma &  [node+1) XML_attributes_clause        & [node) ','
| :breaksAfterComma &  [node+1) 'PARTITION'           & [node) ','
| :breaksAfterConcat &  [node-1) '|'                  & [node) '|'
                      &  ( [node^^^) compound_expression | [node^^^) arith_expr | [(node^^)+10 < (node^^)) )  -- don't break short expressions like this 'hello'||'world'
| :breaksAfterLogicalConjunction &  [node+1) condition  & [node) AND_OR  
| :breaksAfterLogicalConjunction &  [node+1) rel        & [node) AND_OR
| [node) simple_set_expr 
| [node) SET_OPER
| [node) ')' & [node+1) '(' & [node^) range_partitions
| [node) nested_table_col_properties
| [node) with_clause
| [node) pivot_clause 
--| [node) level_clause 
--| [node) hierarchy_clause[14,29)#
;

/**
 * Auxiliary conditions to indent procedure arguments 
 *
 * Rigorous definition:
 * args:  procedureCall < arg 
 *        & ([arg) expr & [arg^) "expr_list"  | [arg) arg & [arg^) arg_list   )
 *        & ([procedureCall) function_call | [procedureCall) function | [procedureCall) procedure_call)
 * ; -- eval time = 7880       (cardinality=9819)
 * commasInProc: [node) ',' 
 *             & (node+1 = args.arg | node-1 = args.arg) 
 * ; -- eval time = 22800       (cardinality=9655)
 * dumbed down/optimized to just commas within procedure scope:
**/
commasInProc: [node) ',' 
       & procedureCall < node 
       & ([procedureCall) function_call | [procedureCall) function | [procedureCall) procedure_call)
; --  eval time = 5305       (cardinality=9655)

extraBrkBefore: 
  ( _extraBrkBefore - commasInProc)
| :breaksBeforeComma & :breaksProcArgs & commasInProc 
->;

extraBrkAfter: 
  ( _extraBrkAfter - commasInProc)
| :breaksAfterComma & :breaksProcArgs & commasInProc 
->;


/**
 * Formal condition when to insert additional line breaks.
 * This is useful to separate sql_statements, or long pl/sql declarations, e.g.
 * 
 *  select 1 from dual;
 *  --<-- additional line break here 
 *  select 2 from dual;
 * 
 * The extra break is inserted _after_ the "node"
 *
 * You can either fine tune the rules below, or
 * just set Options->Advanced Format->Break->After statement to Single Break
 * to disable double line breaks altogether.
**/
brkX2_1: 
  [node) sql_statement
| [node) full_cursor_body
| [node) stmt & ![node^) loop_stmt & ([node^) seq_of_stmts | [node^) stmt_list_opt) & [node+18 < node)  
| [node) ',' & [node+1) method_specification 
| [node) original_method_body_specification
| [node) subprg_body & ![node^) create_plsql
| [node) basic_decl_item_list & [node+1) subprg_body
| [node) is_or_as & [node+1) decl_list & [(node+1)+20 < (node+1)) -- long declarations
| [node) 'BEGIN'
| [node) 'EXCEPTION'
;
brkX2_2: child^=node & (
   [node) stmt & [child) sql_query_or_dml_stmt  
 | [node) stmt & [child) open_cursor_reference_statement
 | [node) basic_decl_item & [child) subprg_spec
) ;
brkX2: 
  brkX2_1 | brkX2_2
->
;

/**
 * All alignments (paddings)
 * This is binary relation: we want all grammar symbols matched by their scope.
 * For example, in  
   [id) identifier & [id+1) datatype & [scope) relational_properties 
 * we are interested in all parse tree nodes named "id" with "identifier" grammar payload.
 * Then, the node following the "id" (i.e. id+1) has to be labeled with "datatype" grammar symbol.
 * Finally, we require the node named "scope" to be labeled with "relational_properties".
 * The condition "scope < id" requires the node named "scope" to be ancestor and the "id" to be descendant.
 * When parse tree nodes are represented as nested intervals, this condition informally stipulates that ancestor's 
 * (i.e. "scope") Date Of Birth precedes that of descendant ("id").
**/
paddedIdsInScope: (
-- types
  :alignTypeDecl & [id) identifier & [id+1) datatype & [scope) relational_properties
| :alignTypeDecl & ( :breaksAfterComma | :breaksBeforeComma ) & [id) decl_id & ([id+1) prm_spec_unconstrained_type | [id+1) 'IN' | [id+1) 'OUT' ) & [scope) fml_part 
                                                                                    & [scope+8 < scope)   -- where "8" is same as in ancestorDescendant
| :alignTypeDecl & ( :breaksAfterComma | :breaksBeforeComma ) & [id) decl_id & ([id+1) constrained_type | [id+1) object_d_rhs) & [scope) adt_definition
| :alignTypeDecl & ( :breaksAfterComma | :breaksBeforeComma ) & [id) decl_id & ([id+1) constrained_type | [id+1) object_d_rhs) & [scope) decl_list
-- =>
| :breaksProcArgs & :alignNamedArgs & [id) sim_expr & [id+1) '=' & [id+2) '>' & [scope) paren_expr_list
-- :=
| :alignAssignments & [id) name & [id+1) ':' & [id+2) '=' & [scope) seq_of_stmts
-- =
--| [id) AND_OR & [id+1) condition &  [scope) where_clause
| :alignEquality & [id) column & [id+1) '=' & [id+2) expr & [scope) on_using_condition
| [id) comparison_condition  & [id+1) 'THEN' & [id+2) expr & [scope) case_expression
| [id) expr  & [id+1) 'THEN' & [id+2) expr & [scope) case_expression
| :alignEquality & [id) expr & [id+1) '=' & [id+2) expr & [scope) where_clause
| [id) column & [id+1) as_alias & [scope) select_clause
--
--| [id) constrained_type & [id+1) default_expr_opt & [scope) decl_list
) & scope < id
->
;

/**
 * incrementalAlignments to shift the entire subquery
 * (formerly was done via laborious specifications of pairwise alignments 
 * of from_clause to select_clause, etc.) e.g.
WITH apms_xml AS ( SELECT
                       amps_armo_id,
           -- adjusted ^
                       amps_polarity_xml
           -- adjusted ^                       
                   FROM
       -- adjusted ^
                       ( SELECT
           -- adjusted ^
... 
 */
incrementalAlignments:  [node) subquery
->
; 

/**
 * Align node to predecessor (if there is a break before the node)
 */ 
pairwiseAlignments1: predecessor = node-1 & (  
    [predecessor) group_by_list[5,12)             & [node) ','
  | [predecessor) order_by_clause[31,38)          & [node) ','
  | [predecessor) select_list                     & [node) ',' 
  | [predecessor) cartesian_product               & [node) ',' 
  | [predecessor) merge_insert_clause[25,32)      & [node) ',' 
  | [predecessor) column                          & [node) merge_insert_clause[25,32) 
  | [predecessor) merge_insert_clause[55,73)      & [node) ',' 
  | [predecessor) column                          & [node) merge_insert_clause[55,73) 
  | !:alignRight & [predecessor) condition              & [node) AND_OR 
  | [predecessor) expr                   & [node) compound_expression[25,44)
  | [predecessor) arith_expr             & [node)   binary_add_op
);
pairwiseAlignments2: predecessor=node-1-1  & (
    [predecessor) select_list    & [node) select_term & [node-1) ',' 
  | [predecessor) cartesian_product      & [node) table_reference   & [node-1) ',' 
  | [predecessor) condition      & [node) condition   & [node-1) AND_OR 
  | [predecessor) adt_field_list & [node) adt_field   & [node-1) ',' 
  | [predecessor) adt_field      & [node) adt_field   & [node-1) ',' 
  | [predecessor) "expr_list"    & [node) expr        & [node-1) ',' 
  | [predecessor) expr           & [node) expr        & [node-1) ',' 
  | !:breakOnSubqueries  & [predecessor) '('    & [node) ')'  & [node-1) query_block & ![node^) par_subquery
);
pairwiseAlignments3: 
  [predecessor) group_by_list
& [predecessor-1) 'BY' 
& (
      [node) ',' 
   |  [node) group_by_col  
)
& ( 
     predecessor=node^ 
   | predecessor=node^^ 
   | predecessor=node^^^ 
   | predecessor=node^^^^ 
   | predecessor=node^^^^^ 
   )
; 
pairwiseAlignments4: ( 
     predecessor=node^-1 
   | predecessor=node^^-1 
   | predecessor=node^^^-1 
   | predecessor=node^^^^-1 
   | predecessor=node^^^^^-1 
   ) 
& [predecessor-1) 'BY' 
& [predecessor) "ord_by_1desc"
& (
      [node) ',' 
   |  [node) "ord_by_1desc" 
);
pairwiseAlignments5: 
  [predecessor) prm_spec
& [node) prm_spec
& predecessor=ancestor-1
& ancestor < node
;
pairwiseAlignments6: 
  [predecessor) update_set_clause_expr
& [node) update_set_clause_expr
& predecessor=ancestor-1
& ancestor < node
;
-- https://community.oracle.com/thread/4119671
-- WHEN NOT MATCHED THEN INSERT (
--     crew_seqno,
--     inoutdte,
--     cardtype,
pairwiseAlignments7: 
  [predecessor) column
& ![predecessor-1) '='
& [node) column
& [node-1) ','
& predecessor=ancestor-1 
& ancestor < node
;
-- https://community.oracle.com/thread/4119671
--e.g. WHEN MATCHED THEN UPDATE SET tgt.inoutdte = src.inoutdte,
--                                  tgt.cardtype = src.cardtype,
--                                  tgt.tfirstnm = src.tfirstnm;
pairwiseAlignments8: 
  [predecessor) column
& [node) column
& predecessor=node^^-3 
;

 
pairwiseAlignments: 
    pairwiseAlignments1 
  | pairwiseAlignments2 
  | pairwiseAlignments3 
  | pairwiseAlignments4 
  | pairwiseAlignments5 
  | pairwiseAlignments6 
  | pairwiseAlignments7 
  | pairwiseAlignments8 
->
;

rightAlignments: :alignRight & (
    [node) 'SELECT' &  [node^) select_clause
  | [node) 'INTO'  
  | [node) 'FROM'   &  [node^) from_clause
  --| [node) 'JOIN'   &  [node^) "inner_cross_join_clause" handled by "inner_cross_join_clause" alignment
  --| [node) 'RIGHT'         &  [node^)  "outer_join_clause"
  | [node) 'WHERE'  &  [node^) where_clause 
  | [node) 'OR'     &  [node^) condition
  | [node) 'AND'    &  [node^) condition
  | [node) 'GROUP'  &  [node^) group_by_clause
  | [node) 'HAVING' &  [node^) having_clause 
  | [node) 'ORDER'  &  [node^) order_by_clause
  | [node) 'UPDATE'  
  | [node) 'SET'   
  | [node) 'FETCH' &  [node^) row_limiting_clause
  | :alignRight & [node) "inner_cross_join_clause"
  | :alignRight & [node) outer_join_type
) ->  
;

/**
 * Extra condition to satisfy requirement of no breaks before parenthesis 
 * https://community.oracle.com/thread/4075004
 */
ignoreLineBreaksBeforeNode:
   !:breaksBeforeComma &    [node) ','
|  [node) ';'
| :breakAfterIf &  [node) pls_expr  &  [node-1) 'IF'
-- | [node) ')' 
->
;
ignoreLineBreaksAfterNode:
   !:breaksAfterComma &    [node) ','
| :breakAfterIf &  [node) pls_expr  &  [node-1) 'IF'
->
;

/**
 * The rule listing which parenthesis padding is not welcome 
 **/
notPaddedParenthesis1:
ancestor < paren & 
 (   [ancestor) constraint  & [ancestor) paren_expr_list 
   | [ancestor) constraint & [ancestor^) constrained_type
   | [ancestor) paren_expr_list & [ancestor^) function_call
   | [ancestor) function_expression
   | [ancestor) model_iterate_clause
   | [ancestor) datetime_literal
   | [ancestor) rollup_cube_clause
   | [ancestor) datatype 
 ) & ( [paren) '(' | [paren) ')' )
; 
notPaddedParenthesis2:
  [paren) '[' | [paren) ']'
;
 
notPaddedParenthesis:
   notPaddedParenthesis1
 |
   notPaddedParenthesis2
->
;

