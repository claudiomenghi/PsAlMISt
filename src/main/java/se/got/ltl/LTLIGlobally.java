package se.got.ltl;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import se.got.ltl.visitors.LTLVisitor;

public class LTLIGlobally extends LTLFormula implements  UnaryFormula<LTLFormula> {

	private final LTLFormula subformula;

	public LTLIGlobally(LTLFormula subformula) {
		super();
		Preconditions.checkNotNull(subformula, "The subformula cannot be null");
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LTLFormula getChild() {
		return this.subformula;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<LTLFormula> getChildren() {
		Set<LTLFormula> formulae=new HashSet<>();
		formulae.add(subformula);
		return formulae;
	}

	
	@Override
	public <T> T accept(LTLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
