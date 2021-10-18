
// gts = simulatorModel.getGTS();
states = gts.getStates();

println('State count: ' + states.size() + '\n');

// ------------------------------------------------

def NODE_COUNT_LIMIT = 9;
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
	'basic-type-with-more-than-one-powertype',
	'categorization-across-multiple-levels',
	'categorizing-more-than-a-type',
	'different-basic-types-with-the-same-powertype',
	'instantiation-across-multiple-levels',
	'instantiation-breaking-categorization',
	'inter-level-specialization',
	'intra-level-categorization',
	'intra-level-instantiation',
	'kind-specializes-sortal',
	'multiple-kinds-for-sortal',
	'mutual-powertype-relation-between-basic-types',
	'non-antirigid-type-specializes-antirigid-type',
	'nonsortal-specializes-sortal',
	'sortal-without-kind',
	'specialization-violation',
	'type-of-more-than-one-basic-type',
	'type-of-no-basic-type',
	'type-specializes-itself',
	'unrelated-basic-types'
];

def violationCount = [0] * (NODE_COUNT_LIMIT);
for (state in states) {
	for (transition in state.getTransitions()) {
		if (conditions.contains(transition.text(false))) {
		    // Detecting conditions
		    // println('\nCondition detected: ' + transition.text(false));
		    
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

