package Farmer.States.Entity;

import Farmer.Farmer;

import java.util.HashMap;

public class EntityManager
{
    private HashMap<String, Farmer> m_map;

    private static  EntityManager m_instance = null;

    private EntityManager() { m_map = new HashMap<String, Farmer>(); }

    public static EntityManager getInstance() { return m_instance != null ? m_instance : (m_instance = new EntityManager()); }

    public void registerEntity(Farmer newEntity){ m_map.put(newEntity.getName(), newEntity); }

    public Farmer getEntity(String s) { Farmer entityFarmer = m_map.get(s); return entityFarmer; }

    public void removeEntity(Farmer entity) { m_map.remove(entity.getID()); }

}
