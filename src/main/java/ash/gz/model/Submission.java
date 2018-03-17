package ash.gz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
public class Submission
{
  @Id
  @GeneratedValue
  private UUID id;

  @Email
  private String email;

  private String firstName;

  private String lastName;

  private String localBoard;

  private boolean receiveGZEmail;

  private boolean fossilFuelTax;

  private boolean waterInfrastructureTax;

  private boolean environmentTargetedRate;

  private boolean transportCheck;

  private boolean housingCheck;

  private boolean environmentCheck;

  private boolean lightRail;

  private boolean busway;

  private boolean frequentRail;

  private boolean cycleNetwork;

  private boolean frequentBus;

  private boolean safeStreets;

  private boolean safetyUpgrades;

  private boolean communityFunding;

  private boolean publicSpaces;

  private boolean lincolnRoad;

  private boolean millRoad;

  private boolean maoriWards;

  private String extraTransportProjectsSupport;

  private String extraTransportProjectsDoNotSupport;

  private String extraEnvironmentalProjects;

  private String extraHousingProjects;

  private String otherComments;

  public UUID getId()
  {
    return id;
  }

  public void setId(UUID id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getLocalBoard()
  {
    return localBoard;
  }

  public void setLocalBoard(String localBoard)
  {
    this.localBoard = localBoard;
  }

  public boolean isReceiveGZEmail()
  {
    return receiveGZEmail;
  }

  public void setReceiveGZEmail(boolean receiveGZEmail)
  {
    this.receiveGZEmail = receiveGZEmail;
  }

  public boolean isFossilFuelTax()
  {
    return fossilFuelTax;
  }

  public void setFossilFuelTax(boolean fossilFuelTax)
  {
    this.fossilFuelTax = fossilFuelTax;
  }

  public boolean isWaterInfrastructureTax()
  {
    return waterInfrastructureTax;
  }

  public void setWaterInfrastructureTax(boolean waterInfrastructureTax)
  {
    this.waterInfrastructureTax = waterInfrastructureTax;
  }

  public boolean isEnvironmentTargetedRate()
  {
    return environmentTargetedRate;
  }

  public void setEnvironmentTargetedRate(boolean environmentTargetedRate)
  {
    this.environmentTargetedRate = environmentTargetedRate;
  }

  public boolean isTransportCheck()
  {
    return transportCheck;
  }

  public void setTransportCheck(boolean transportCheck)
  {
    this.transportCheck = transportCheck;
  }

  public boolean isHousingCheck()
  {
    return housingCheck;
  }

  public void setHousingCheck(boolean housingCheck)
  {
    this.housingCheck = housingCheck;
  }

  public boolean isEnvironmentCheck()
  {
    return environmentCheck;
  }

  public void setEnvironmentCheck(boolean environmentCheck)
  {
    this.environmentCheck = environmentCheck;
  }

  public boolean isLightRail()
  {
    return lightRail;
  }

  public void setLightRail(boolean lightRail)
  {
    this.lightRail = lightRail;
  }

  public boolean isBusway()
  {
    return busway;
  }

  public void setBusway(boolean busway)
  {
    this.busway = busway;
  }

  public boolean isFrequentRail()
  {
    return frequentRail;
  }

  public void setFrequentRail(boolean frequentRail)
  {
    this.frequentRail = frequentRail;
  }

  public boolean isCycleNetwork()
  {
    return cycleNetwork;
  }

  public void setCycleNetwork(boolean cycleNetwork)
  {
    this.cycleNetwork = cycleNetwork;
  }

  public boolean isFrequentBus()
  {
    return frequentBus;
  }

  public void setFrequentBus(boolean frequentBus)
  {
    this.frequentBus = frequentBus;
  }

  public boolean isSafeStreets()
  {
    return safeStreets;
  }

  public void setSafeStreets(boolean safeStreets)
  {
    this.safeStreets = safeStreets;
  }

  public boolean isSafetyUpgrades()
  {
    return safetyUpgrades;
  }

  public void setSafetyUpgrades(boolean safetyUpgrades)
  {
    this.safetyUpgrades = safetyUpgrades;
  }

  public boolean isCommunityFunding()
  {
    return communityFunding;
  }

  public void setCommunityFunding(boolean communityFunding)
  {
    this.communityFunding = communityFunding;
  }

  public boolean isPublicSpaces()
  {
    return publicSpaces;
  }

  public void setPublicSpaces(boolean publicSpaces)
  {
    this.publicSpaces = publicSpaces;
  }

  public boolean isLincolnRoad()
  {
    return lincolnRoad;
  }

  public void setLincolnRoad(boolean lincolnRoad)
  {
    this.lincolnRoad = lincolnRoad;
  }

  public boolean isMillRoad()
  {
    return millRoad;
  }

  public void setMillRoad(boolean millRoad)
  {
    this.millRoad = millRoad;
  }

  public boolean isMaoriWards()
  {
    return maoriWards;
  }

  public void setMaoriWards(boolean maoriWards)
  {
    this.maoriWards = maoriWards;
  }

  public String getExtraTransportProjectsSupport()
  {
    return extraTransportProjectsSupport;
  }

  public void setExtraTransportProjectsSupport(String extraTransportProjectsSupport)
  {
    this.extraTransportProjectsSupport = extraTransportProjectsSupport;
  }

  public String getExtraTransportProjectsDoNotSupport()
  {
    return extraTransportProjectsDoNotSupport;
  }

  public void setExtraTransportProjectsDoNotSupport(String extraTransportProjectsDoNotSupport)
  {
    this.extraTransportProjectsDoNotSupport = extraTransportProjectsDoNotSupport;
  }

  public String getExtraEnvironmentalProjects()
  {
    return extraEnvironmentalProjects;
  }

  public void setExtraEnvironmentalProjects(String extraEnvironmentalProjects)
  {
    this.extraEnvironmentalProjects = extraEnvironmentalProjects;
  }

  public String getExtraHousingProjects()
  {
    return extraHousingProjects;
  }

  public void setExtraHousingProjects(String extraHousingProjects)
  {
    this.extraHousingProjects = extraHousingProjects;
  }

  public String getOtherComments()
  {
    return otherComments;
  }

  public void setOtherComments(String otherComments)
  {
    this.otherComments = otherComments;
  }
}
