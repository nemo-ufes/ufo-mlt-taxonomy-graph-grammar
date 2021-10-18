memberchk(X,[X|_]) :- !.
memberchk(X,[_|T]):- memberchk(X,T).

has_n_nodes(State, N) :-
  closed_state(State),
  state_graph(State, Graph),
  graph_node_count(Graph, N)
  .

has_any_condition(State) :-
	closed_state(State),
	state_graph(State, Graph),
	state_transition(State, Transition),
	edge_label(Transition, RuleName),
	memberchk(RuleName, [
		'categorization-between-not-adjacent-levels',
		'categorization-redundancy',
	  	'instantiation-between-not-adjacent-levels',
		'instantiation-breaking-categorization',
		'instantiation-breaking-partition',
		'instantiation-breaking-subordination',
		'partition-between-not-adjacent-levels',
		'specialization-between-different-levels',
		'specialization-between-two-types-partitioning-the-same',
		'submitting-instances-to-more-than-a-type',
		'subordination-between-different-levels',
		'subordination-to-a-specialization'
	]).

has_condition(State, N) :-
  closed_state(State),
  state_graph(State, Graph),
  graph_node_count(Graph, N),
  state_transition(State, Transition),
  edge_label(Transition, RuleName),
  memberchk(RuleName, [
	'categorization-between-not-adjacent-levels',
	'categorization-redundancy',
  	'instantiation-between-not-adjacent-levels',
	'instantiation-breaking-categorization',
	'instantiation-breaking-partition',
	'instantiation-breaking-subordination',
	'partition-between-not-adjacent-levels',
	'specialization-between-different-levels',
	'specialization-between-two-types-partitioning-the-same',
	'submitting-instances-to-more-than-a-type',
	'subordination-between-different-levels',
	'subordination-to-a-specialization'
  ]).

report(N) :-
  findall(IState, has_any_condition(IState), DuplIncorrectStates),
  sort(DuplIncorrectStates, IncorrectStates),
  write('  '), length(IncorrectStates, IS), write(IS), write(' states with conditions'), nl,
  findall(State, has_condition(State, N), States),
  write('  '), length(States, L), write(L), write(' states with conditions out of'), nl,
  findall(State1, has_n_nodes(State1, N), States1),
  write('  '), length(States1, L1), write(L1), write(' states with '), write(N), write(' nodes.'), nl
  .
