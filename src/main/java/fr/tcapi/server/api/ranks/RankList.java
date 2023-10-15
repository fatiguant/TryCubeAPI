package fr.tcapi.server.api.ranks;

public enum RankList {

    ADMIN("Admin","§4Admin§f ・§4", "§4Admin", "400", true),
    MANAGER("Manager","§9Manager§f ・§9", "§9Manager", "300", true),
    MODP("Mod+","§9Mod+§f ・§9", "§3Mod+", "200", true),
    MOD("Mod","§9Mod§f ・§9", "§3Mod", "100", true),
    HELPER("Helper","§bHelper§f ・§b", "§bHelper", "90", true),
    BUIDLER("Builder","§2Builder§f ・§2", "§2Builder", "80", true),
    DEV("Dev","§2Dév§f ・§2", "§2Dév", "70", true),
    AMI("Ami","§fAmi§f ・§f", "§fAmi", "60", true),
    PARTNER("Partner","§6Partner§f ・§6", "§6Partner", "50", true),
    EPIC("Epic","§3Epic§f ・§3", "§3Epic", "40", false),
    VIP2("VIP+","§aVIP+§f ・§a", "§aVIP+", "30", false),
    VIP("VIP","§eVIP§f ・§e", "§eVIP", "20", false),
    DEFAULT("Joueur", "§7", "§7Joueur", "10", false);

    private String yamlName;
    private String igPrefix;
    private String sbDisplay;
    private String power;

    private boolean getBadge;

    RankList(String yamlName, String igPrefix, String scoreboardDisplay, String Power, boolean haveBadge) {
        this.yamlName = yamlName;
        this.igPrefix = igPrefix;
        this.sbDisplay = scoreboardDisplay;
        this.power = Power;
        this.getBadge = haveBadge;
    }

    public String getRankName() {
        return yamlName;
    }

    public String getSbDisplay() {
        return sbDisplay;
    }

    public String getPrefix() {
        return igPrefix;
    }

    public String getPower() {
        return power;
    }

    public boolean haveBadge() {
        return getBadge;
    }

    public static RankList getByRankName(String rankName) {
        for (RankList rank : values()) {
            if (rank.getRankName().equalsIgnoreCase(rankName)) {
                return rank;
            }
        }
        return null; // or throw an exception if desired
    }
}
