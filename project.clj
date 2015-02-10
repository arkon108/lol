(defproject lol "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.6.0"]  [org.clojure/math.numeric-tower "0.0.4"]]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot [lol.core]
  :main lol.core)
