package vn.jv.persist.repositories;

import vn.jv.persist.BaseRepo;
import vn.jv.persist.domain.WorkCategory;

/**
 * 
 * @author hunglevn@outlook.com
 *
 */
public interface WorkCategoryRepo extends BaseRepo<WorkCategory, Integer>, WorkCategoryCustomRepo<WorkCategory, Integer> {

}
