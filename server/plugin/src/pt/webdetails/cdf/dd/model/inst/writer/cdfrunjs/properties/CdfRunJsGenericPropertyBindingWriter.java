
package pt.webdetails.cdf.dd.model.inst.writer.cdfrunjs.properties;

import org.apache.commons.lang.StringUtils;
import pt.webdetails.cdf.dd.model.core.writer.ThingWriteException;
import pt.webdetails.cdf.dd.model.inst.PropertyBinding;
import pt.webdetails.cdf.dd.model.inst.writer.cdfrunjs.dashboard.CdfRunJsDashboardWriteContext;

/**
 * @author Duarte
 */
public class CdfRunJsGenericPropertyBindingWriter extends CdfRunJsPropertyBindingWriter
{
  public void write(StringBuilder out, CdfRunJsDashboardWriteContext context, PropertyBinding propBind) throws ThingWriteException
  {
    String indent = context.getIndent();
    
    String jsValue = writeValue(propBind);
    if(StringUtils.isNotEmpty(jsValue))
    {
      addJsProperty(out, propBind.getAlias(), jsValue, indent, context.isFirstInList());
      
      context.setIsFirstInList(false);
    }
  }
  
  private String writeValue(PropertyBinding propBind)
  {
    String canonicalValue = propBind.getValue();
    if(StringUtils.isNotEmpty(canonicalValue))
    {
      switch(propBind.getProperty().getValueType())
      {
        case STRING:   return this.writeString(canonicalValue);
        case BOOLEAN:  return this.writeBoolean(canonicalValue);
        case NUMBER:   return this.writeNumber(canonicalValue);
        case ARRAY:    return this.writeArray(canonicalValue);
        case FUNCTION: return this.writeFunction(canonicalValue);
        case LITERAL:  return this.writeLiteral(canonicalValue);
        case QUERY:    return this.writeQuery(canonicalValue);
        //case VOID:
      }
    }
    
    return ""; // empty canonical or VOID
  }
  
  private String writeQuery(String canonicalValue)
  {
    throw new UnsupportedOperationException("Feature implemented in DatasourceProperty Writer -- something went wrong!");
  }
}
