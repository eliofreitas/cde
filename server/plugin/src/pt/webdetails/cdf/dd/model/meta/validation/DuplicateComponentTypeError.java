
package pt.webdetails.cdf.dd.model.meta.validation;

import pt.webdetails.cdf.dd.model.meta.ComponentType;

/**
 * @author dcleao
 */
public final class DuplicateComponentTypeError extends ComponentTypeError
{
  public DuplicateComponentTypeError(ComponentType comp)
  {
    super(getCompLabel(comp));
  }

  @Override
  public String toString()
  {
    return "ComponentType '" + this._componentTypeLabel + "' is defined twice.";
  }

  private static String getCompLabel(ComponentType comp)
  {
    if(comp == null) { throw new IllegalArgumentException("comp"); }
    return comp.getLabel();
  }
}
