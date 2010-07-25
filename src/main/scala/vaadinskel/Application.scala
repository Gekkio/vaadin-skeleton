package vaadinskel

import com.vaadin.ui._

class Application extends com.vaadin.Application {
  def init {
    val w = new Window("Vaadin Skeleton")
    w.addComponent(new Label("Hello World!"))
    setMainWindow(w)
  }
}
