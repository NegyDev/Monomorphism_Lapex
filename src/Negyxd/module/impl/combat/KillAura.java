package Negyxd.module.impl.combat;

import Negyxd.Event.Event;
import Negyxd.Event.impl.MotionEvent;
import Negyxd.Gui.ClickGui.setting.SettingsManager;
import Negyxd.Mappings.Minecraft;
import Negyxd.Mappings.ThePlayer;
import Negyxd.module.Category;
import Negyxd.module.Module;
import net.minecraft.B5;
import net.minecraft.bY;
import net.minecraft.hv;
import org.lwjgl.input.Keyboard;

public class KillAura extends Module {
    private long lastAttackTime = 0L;
    private long attackCooldown;
    public KillAura() {
        super("KillAura", Keyboard.KEY_R, Category.Combat);
        SettingsManager.manager.addDouble("Range", "KillAuraRange", 1, 6.0, 3.6, this);
        SettingsManager.manager.addDouble("Max CPS", "KillAuraMaxCps", 1, 20.0, 7, this);
        SettingsManager.manager.addDouble("Min CPS", "KillAuraMinCps", 1, 20.0, 7, this);
        SettingsManager.manager.addBoolean("Swing", "KillAuraSwing", true, this);
    }

    @Override
    public void onEvent(Event event) {
        if(event instanceof MotionEvent){
            for(B5 entity: Minecraft.getWorld().M){
                if(entity == Minecraft.getPlayer())continue;
                if(entity==null)continue;
                if(entity instanceof net.minecraft.OI){
                    float distance = Minecraft.getPlayer().k(entity);
                    if(distance <= SettingsManager.manager.getSettingByName("KillAuraRange").getValDouble()){
                        if(ThePlayer.onGround()){
                            Attack(entity);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void faceEntity(B5 entity) {
        final float[] rotations = getRotationsNeeded(entity);
        ThePlayer.sendPacket(new bY(rotations[0],rotations[1],true));
    }
    public static float[] getRotationsNeeded(B5 entity) {
        double deltaX = entity.Fy - ThePlayer.getPosX();
        double deltaY = entity.L - ThePlayer.getPosY();
        double deltaZ = entity.F4 - ThePlayer.getPosZ();

        double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

        float yaw = (float) Math.toDegrees(-Math.atan2(deltaX, deltaZ));
        float pitch = (float) Math.toDegrees(-Math.atan2(deltaY, distance));

        return new float[]{yaw, pitch};
    }
    public void Attack(B5 Entity){
        long currentTime = System.currentTimeMillis();
        double maxCps = SettingsManager.manager.getSettingByName("KillAuraMaxCps").getValDouble();
        double minCps = SettingsManager.manager.getSettingByName("KillAuraMinCps").getValDouble();
        attackCooldown = (long) (1000 / (Math.random() * (maxCps - minCps) + minCps));

        if (currentTime - lastAttackTime >= attackCooldown) {
            float distance = Minecraft.getPlayer().k(Entity);
            if(distance <= SettingsManager.manager.getSettingByName("KillAuraRange").getValDouble()){
                faceEntity(Entity);
                Minecraft.getMinecraft().o.R(Minecraft.getPlayer(), Entity);
                Minecraft.getPlayer().Kd.O(new hv());
            }
            lastAttackTime = currentTime;
        }
    }
    public void Attackv2(B5 Entity){
        long currentTime = System.currentTimeMillis();
        double maxCps = SettingsManager.manager.getSettingByName("KillAuraMaxCps").getValDouble();
        double minCps = SettingsManager.manager.getSettingByName("KillAuraMinCps").getValDouble();
        attackCooldown = (long) (1000 / (Math.random() * (maxCps - minCps) + minCps));

        if (currentTime - lastAttackTime >= attackCooldown) {
            float distance = Minecraft.getPlayer().k(Entity);
            if(distance <= SettingsManager.manager.getSettingByName("KillAuraRange").getValDouble()){
                faceEntity(Entity);
                Minecraft.getMinecraft().o.R(Minecraft.getPlayer(), Entity);
                Minecraft.getPlayer().Kd.O(new hv());
            }
            lastAttackTime = currentTime;
        }
    }
}
