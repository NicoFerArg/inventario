
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Parts;
import java.util.List;

/**
 *
 * @author flobos
 */
public interface PartDao {
    
    
    public List<Parts> listPart();
    public void createPart(Parts p);
    public void deletePart(Parts p);
    public List<Parts> listByBrand(int id_brand);
   
}
