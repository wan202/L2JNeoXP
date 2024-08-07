package net.sf.l2j.gameserver.scripting.script.ai.individual.Monster.RaidBoss.RaidBossParty;

import net.sf.l2j.commons.random.Rnd;

import net.sf.l2j.gameserver.enums.actors.NpcSkillType;
import net.sf.l2j.gameserver.model.actor.Creature;
import net.sf.l2j.gameserver.model.actor.Npc;
import net.sf.l2j.gameserver.model.actor.Playable;
import net.sf.l2j.gameserver.model.actor.Player;
import net.sf.l2j.gameserver.skills.L2Skill;

public class RaidBossType3 extends RaidBossParty
{
	public RaidBossType3()
	{
		super("ai/individual/Monster/RaidBoss/RaidBossAlone/RaidBossParty/RaidBossType3");
	}
	
	public RaidBossType3(String descr)
	{
		super(descr);
	}
	
	protected final int[] _npcIds =
	{
		25269,
		25035,
		25342,
		25299,
		25146,
		25004,
		25010,
		25026,
		25041,
		25057,
		25067,
		25085,
		25106,
		25115,
		25131,
		25149,
		25170,
		25185,
		25211,
		25217,
		25241,
		25256,
		25260,
		25362,
		25388,
		25412,
		25444,
		25475,
		25490,
		25501,
		29096
	};
	
	@Override
	public void onPartyAttacked(Npc caller, Npc called, Creature target, int damage)
	{
		if (target instanceof Playable)
		{
			final Creature topDesireTarget = called.getAI().getTopDesireTarget();
			if (target == topDesireTarget && Rnd.get(15) < 1)
			{
				final L2Skill physicalSpecial_b = getNpcSkillByType(called, NpcSkillType.PHYSICAL_SPECIAL_B);
				called.getAI().addCastDesire(target, physicalSpecial_b, 1000000);
			}
		}
		super.onPartyAttacked(caller, called, target, damage);
	}
	
	@Override
	public void onSeeSpell(Npc npc, Player caster, L2Skill skill, Creature[] targets, boolean isPet)
	{
		final Creature topDesireTarget = npc.getAI().getTopDesireTarget();
		if (topDesireTarget != null && caster == topDesireTarget && Rnd.get(15) < 1)
		{
			final L2Skill physicalSpecial_b = getNpcSkillByType(npc, NpcSkillType.PHYSICAL_SPECIAL_B);
			npc.getAI().addCastDesire(caster, physicalSpecial_b, 1000000);
		}
		super.onSeeSpell(npc, caster, skill, targets, isPet);
	}
}