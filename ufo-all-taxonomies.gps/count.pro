memberchk(X,[X|_]) :- !.
memberchk(X,[_|T]):- memberchk(X,T).

has_n_nodes(State, N) :-
  closed_state(State),
  state_graph(State, Graph),
  graph_node_count(Graph, N)
  .

has_condition(State, N) :-
  closed_state(State),
  state_graph(State, Graph),
  graph_node_count(Graph, N),
  state_transition(State, Transition),
  edge_label(Transition, RuleName),
  memberchk(RuleName, [
	'kind-specializes-sortal',
	'multiple-kinds-for-sortal',
	'non-antirigid-type-specializes-antirigid-type',
	'nonsortal-specializes-sortal',
	'sortal-without-kind',
	'type-specializes-itself'
  ]).

report(N) :-
  findall(State, has_condition(State, N), States),
  sort(States, NoDuplStates),
  write('  '), length(NoDuplStates, L), write(L), write(' states with conditions, out of'), nl,
  findall(State1, has_n_nodes(State1, N), States1),
  write('  '), length(States1, L1), write(L1), write(' states with '), write(N), write(' nodes.'), nl
  .
