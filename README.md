# ufo-mlt-taxonomy-graph-grammar

## Content

* 5 [GROOVE](https://sourceforge.net/projects/groove/) grammars
  * ufo-sound-taxonomies.gps
  * ufo-all-taxonomies.gps
  * mlt-sound-taxonomies.gps
  * mlt-all-taxonomies.gps
  * ufo-mlt-sound-taxonomies.gps

## Requirements

* GROOVE 5.8.1 or latter
* Java 8

## Selecting the number of types in each modeled taxonomy

To select the __number of types__ in each checked taxonomy in the experiments with a certain grammar, one need to select a _control program_ for this grammar. The name of each control program is of the form "control-`n`", where `n` means:
* The _actual number of types_ in each taxonomy, for the __ufo-sound-taxonomies__ and __ufo-all-taxonomies__ grammars or;
* The _number of types, excluding the **Individual** class_, in each taxonomy, for the remaining grammars, which describe multi-level concepts.

To select the _control program_ to be used, one can either:
* Manually edit the system.properties file in the grammar folder, changing the value of the parameter controlProgram to "control-`n`" or;
* Use the [GROOVE](https://sourceforge.net/projects/groove/) Simulator tool to enable just one control program for the grammar.
  
## Running the experiments

Having selected the __number of types__ in each taxonomy for the experiments, to run them, in a Linux system, open a terminal in the root directory of this repo and run the following command:

java -jar $GROOVE/bin/GroovyChecker.jar -p analysis -g `grammar`, where $GROOVE is the extracted GROOVE folder and `grammar` is the folder of the grammar to be tested.
