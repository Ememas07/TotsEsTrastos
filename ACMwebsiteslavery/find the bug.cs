foreach (Driver member in team.TeamMembers)
                    {   
                        int? memberIncome = 0;

                        // Check if member participated in the race
                        if (races.Any(r => r.SteamId == member.SteamId && r.Team == team.TeamId && r.CarUsed != 0))
                        {
                            // Calculate team sponsor income
                            foreach (Sponsor teamSponsor in new List<Sponsor> { team.Sponsor1, team.Sponsor2, team.Sponsor3 })
                            {
                                bool teamTarget = await _driverService.CheckTarget(connection, teamSponsor.Target, member.SteamId, raceCode, races.First(r => r.SteamId == member.SteamId));
                                int sponsorIncome = teamSponsor.RaceBonus + (teamTarget ? teamSponsor.TargetBonus : 0);

                                if (member.DiscordId == teamOwner.DiscordId)
                                {
                                    // Team owner gets 100% of their own sponsor income
                                    teamOwnerIncome += sponsorIncome;
                                }
                                else
                                {
                                    // Team owner gets 50% of each team member's sponsor income
                                    teamOwnerIncome += sponsorIncome / 2;
                                    // Team members get their full sponsor income
                                    memberIncome += sponsorIncome;
                                }
                            }

                            // Add team payout to members, subtract from the team owner
                            string contractQuery = @"SELECT Payout FROM [dbo].[Contracts] WHERE DiscordId = @DiscordId AND TeamId = @TeamId";
                            using (SqlCommand contractCommand = new SqlCommand(contractQuery, connection))
                            {
                                contractCommand.Parameters.Add("@DiscordId", SqlDbType.VarChar).Value = member.DiscordId;
                                contractCommand.Parameters.Add("@TeamId", SqlDbType.Int).Value = team.TeamId;

                                var result = await contractCommand.ExecuteScalarAsync();
                                if (result != null && result != DBNull.Value)
                                {
                                    double payout = (double)result;
                                    if (member.DiscordId != teamOwner.DiscordId)
                                    {
                                        memberIncome += (int)payout;
                                    }
                                    teamOwnerIncome -= (int)payout;
                                }
                            }
                            await UpdateDriverIncome(connection, member.SteamId, memberIncome, "MemberIncome", raceCode);