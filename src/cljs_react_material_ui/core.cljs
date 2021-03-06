(ns cljs-react-material-ui.core
  (:refer-clojure :exclude [list stepper])
  (:require-macros [cljs-react-material-ui.elements :as me])
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [cljsjs.material-ui]))

(defn ^:private kebab->camel [kw]
  (keyword (str/replace (name kw) #"-(\w)" (comp str/upper-case second))))

(defn ^:private walk-map-keys [f props]
  (let [f' (fn [[k v]] [(f k) v])]
    (walk/postwalk (fn [x] (if (map? x) (into {} (map f' x)) x)) props)))

(def props-kebab->camel->js (comp clj->js (partial walk-map-keys kebab->camel)))

(defn create-mui-cmp [root-obj type args]
  (let [first-arg (first args)
        args (if (or (map? first-arg) (nil? first-arg)) args (cons {} args))]
    (apply js/React.createElement (aget root-obj type)
           (props-kebab->camel->js (first args)) (rest args))))

(defn get-mui-theme
  ([] (get-mui-theme nil))
  ([raw-theme] (-> raw-theme
                   props-kebab->camel->js
                   js/MaterialUIStyles.getMuiTheme)))

(defn color [color-key]
  (aget js/MaterialUIStyles "colors" (name (kebab->camel color-key))))

(def create-mui-el (partial create-mui-cmp js/MaterialUI))

(defn app-bar [& args] (create-mui-el "AppBar" args))
(defn auto-complete [& args] (create-mui-el "AutoComplete" args))
(defn avatar [& args] (create-mui-el "Avatar" args))
(defn badge [& args] (create-mui-el "Badge" args))
(defn card [& args] (create-mui-el "Card" args))
(defn card-actions [& args] (create-mui-el "CardActions" args))
(defn card-header [& args] (create-mui-el "CardHeader" args))
(defn card-media [& args] (create-mui-el "CardMedia" args))
(defn card-title [& args] (create-mui-el "CardTitle" args))
(defn card-text [& args] (create-mui-el "CardText" args))
(defn checkbox [& args] (create-mui-el "Checkbox" args))
(defn chip [& args] (create-mui-el "Chip" args))
(defn circular-progress [& args] (create-mui-el "CircularProgress" args))
(defn date-picker [& args] (create-mui-el "DatePicker" args))
(defn dialog [& args] (create-mui-el "Dialog" args))
(defn divider [& args] (create-mui-el "Divider" args))
(defn drawer [& args] (create-mui-el "Drawer" args))
(defn drop-down-menu [& args] (create-mui-el "DropDownMenu" args))
(defn flat-button [& args] (create-mui-el "FlatButton" args))
(defn floating-action-button [& args] (create-mui-el "FloatingActionButton" args))
(defn font-icon [& args] (create-mui-el "FontIcon" args))
(defn grid-list [& args] (create-mui-el "GridList" args))
(defn grid-tile [& args] (create-mui-el "GridTile" args))
(defn icon-button [& args] (create-mui-el "IconButton" args))
(defn icon-menu [& args] (create-mui-el "IconMenu" args))
(defn linear-progress [& args] (create-mui-el "LinearProgress" args))
(defn list [& args] (create-mui-el "List" args))
(defn list-item [& args] (create-mui-el "ListItem" args))
(defn make-selectable [& args] (create-mui-el "MakeSelectable" args))
(defn menu [& args] (create-mui-el "Menu" args))
(defn menu-item [& args] (create-mui-el "MenuItem" args))
(defn mui-theme-provider [& args] (create-mui-el "MuiThemeProvider" args))
(defn paper [& args] (create-mui-el "Paper" args))
(defn popover [& args] (create-mui-el "Popover" args))
(defn radio-button [& args] (create-mui-el "RadioButton" args))
(defn radio-button-group [& args] (create-mui-el "RadioButtonGroup" args))
(defn raised-button [& args] (create-mui-el "RaisedButton" args))
(defn refresh-indicator [& args] (create-mui-el "RefreshIndicator" args))
(defn select-field [& args] (create-mui-el "SelectField" args))
(defn slider [& args] (create-mui-el "Slider" args))
(defn subheader [& args] (create-mui-el "Subheader" args))
(defn svg-icon [& args] (create-mui-el "SvgIcon" args))
(defn step [& args] (create-mui-el "Step" args))
(defn step-button [& args] (create-mui-el "StepButton" args))
(defn step-content [& args] (create-mui-el "StepContent" args))
(defn step-label [& args] (create-mui-el "StepLabel" args))
(defn stepper [& args] (create-mui-el "Stepper" args))
(defn snackbar [& args] (create-mui-el "Snackbar" args))
(defn tabs [& args] (create-mui-el "Tabs" args))
(defn tab [& args] (create-mui-el "Tab" args))
(defn table [& args] (create-mui-el "Table" args))
(defn table-body [& args] (create-mui-el "TableBody" args))
(defn table-footer [& args] (create-mui-el "TableFooter" args))
(defn table-header [& args] (create-mui-el "TableHeader" args))
(defn table-header-column [& args] (create-mui-el "TableHeaderColumn" args))
(defn table-row [& args] (create-mui-el "TableRow" args))
(defn table-row-column [& args] (create-mui-el "TableRowColumn" args))
(defn text-field [& args] (create-mui-el "TextField" args))
(defn time-picker [& args] (create-mui-el "TimePicker" args))
(defn toggle [& args] (create-mui-el "Toggle" args))
(defn toolbar [& args] (create-mui-el "Toolbar" args))
(defn toolbar-group [& args] (create-mui-el "ToolbarGroup" args))
(defn toolbar-separator [& args] (create-mui-el "ToolbarSeparator" args))
(defn toolbar-title [& args] (create-mui-el "ToolbarTitle" args))


