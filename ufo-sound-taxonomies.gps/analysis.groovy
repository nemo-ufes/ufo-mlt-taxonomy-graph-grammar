
// gts = simulatorModel.getGTS();
states = gts.getStates();

println('State count: ' + states.size() + '\n');

// ------------------------------------------------

def NODE_COUNT_LIMIT = 8;
def nodeCount = [0] * (NODE_COUNT_LIMIT);

for (state in states) {
	def realNodeCount = 0;
	for (node in state.getGraph().nodeSet()) {
		if (!node.getType().isDataType()) {
			realNodeCount++;
		}
	}
	nodeCount[realNodeCount]++;
}

for (int i = 0; i < NODE_COUNT_LIMIT; i++) {
	println(nodeCount[i] + ' states with ' + i + ' nodes.');
}

// ------------------------------------------------

conditions = [
	'kind-specializes-sortal',
	'multiple-kinds-for-sortal',
	'non-antirigid-type-specializes-antirigid-type',
	'nonsortal-specializes-sortal',
	'sortal-without-kind',
	'type-specializes-itself'
];

def violationCount = [0] * (NODE_COUNT_LIMIT);
for (state in states) {
	for (transition in state.getTransitions()) {
		if (conditions.contains(transition.text(false))) {
		    // Detecting conditions
		    println('\nCondition detected: ' + transition.text(false));
		    
			def realNodeCount = 0;
			for (node in state.getGraph().nodeSet()) {
				if (!node.getType().isDataType()) {
					realNodeCount++;
				}
			}
			violationCount[realNodeCount]++;
			break;
		}
	}
}

println();
for (int i = 0; i < NODE_COUNT_LIMIT; i++) {
	println(violationCount[i] + ' states with ' + i + ' nodes violate some condition.');
}

println('\n' + 'Violation count: ' + violationCount.sum());

