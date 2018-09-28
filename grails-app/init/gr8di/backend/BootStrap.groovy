package gr8di.backend

class BootStrap {

    def init = { servletContext ->
        new Message(senderEmail:"johnDoe@email.com", topic:"jobs", messageBody:"hello john doe", dateSent: new Date(), status: Status.Read).save()
        new Message(senderEmail:"janeDoe@email.com", topic:"internship", messageBody:"hello jane doe", dateSent: new Date(), status: Status.New).save()
        new Job(emailAddress: "bobcarl@gmail.com", jobExperienceLevel: "entry level", jobType: "fulltime", tags: "grails, ratpack", salaryRangeFrom: 500, salaryRangeTo: 2000, jobDescription: "As a grails backend developer", jobTitle: "grail developer", companyName: "gr8di", jobLocation: "washington").save()
        new Job(emailAddress: "carlito@gmail.com", jobExperienceLevel: "intermediate level", jobType: "part-time", tags: "groovy", salaryRangeFrom: 200, salaryRangeTo: 2000, jobDescription: "As a ratpack backend developer", jobTitle: "groovy developer", companyName: "appstech", jobLocation: "Buea").save()

        def pitch1 = new Pitch(imgUrl: "image", icon: "Icon", title: "pitch1", description: "pitch4gr8", action: "redirect").save()
        def member1 = new Member(imgUrl: "mimage", name: "member", handle: "@bichiroy", role: "backend").save()
        def card1 = new Card(imgUrl: "image", header: "card", description: "a card", footer: "Bottom card").save()
        //def section1 = new Section(title: "Section1", description: "section test", pitch: pitch1, card: card1, member: member1).save()

        new Document(language: "UK", pageName: "index Document", title: "Gr8di intro", subtitle: "gr8disub", imgUrl: "pageurlimage",section: new Section(title: "Section1", description: "section test", pitch: pitch1, card: card1, member: member1), pageStatus: PageStatus.active).save(failOnError: true)

        new Mentor( mentorName: "Debenick", workDays: "Monday",timeZone: "GMT+1", menteeAgeRange: "Groovy,12",specialSkills: "3D", groovyExp: GroovyExp.plusFive, libFrmwrkTools: LibFrmwrkTools.Ratpack, language: Language.English, hrsPerWeek: HrsPerWeek.FourToSix, timeOfStart: TimeOfStart.immediately)
                .addToMentee(new Mentee(menteeName: "Gisele", timeZone: "Gmt", workDays: "Monday", specialSkills: "C lang", menteeExp: MenteeExp.sixMonthCourse, libFrmwrkTools: LibFrmwrkTools.grails, language: Language.English, hrsPerWeek: HrsPerWeek.FourToSix, timeOfStart: TimeOfStart.immediately,goal: Goal.AskForPaidJob))
                .addToMentee(new Mentee(menteeName: "Gisele", timeZone: "Gmt", workDays: "Monday", specialSkills: "C lang", menteeExp: MenteeExp.sixMonthCourse, libFrmwrkTools: LibFrmwrkTools.grails, language: Language.English, hrsPerWeek: HrsPerWeek.FourToSix, timeOfStart: TimeOfStart.immediately,goal: Goal.AskForPaidJob)).save()
    }

    def destroy = {
    }
}
